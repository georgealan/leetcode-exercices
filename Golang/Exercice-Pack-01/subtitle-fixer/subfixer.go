package main

import (
	"bufio"
	"errors"
	"fmt"
	"io"
	"log"
	"os"
	"regexp"
	"strconv"
	"strings"
	"time"
)

/*
The bug was only a issue with the file decode format, this script verify if the file are
in ASCII, the text need to be in ASCII to be accepted.
*/

type Subtitle struct {
	idx      int
	fromTime time.Duration
	toTime   time.Duration
	text     string
}

var timeFramePattern, _ = regexp.Compile(`(\d+):(\d+):(\d+),(\d+) --> (\d+):(\d+):(\d+),(\d+)`)

func getDuration(parts []string) time.Duration {
	hour, _ := strconv.Atoi(parts[0])
	minute, _ := strconv.Atoi(parts[1])
	second, _ := strconv.Atoi(parts[2])
	millisecond, _ := strconv.Atoi(parts[3])
	return time.Millisecond*time.Duration(millisecond) +
		time.Second*time.Duration(second) +
		time.Minute*time.Duration(minute) +
		time.Hour*time.Duration(hour)
}

func printDuration(duration time.Duration) string {
	hour := duration / time.Hour
	duration -= hour * time.Hour
	minute := duration / time.Minute
	duration -= minute * time.Minute
	second := duration / time.Second
	duration -= second * time.Second
	millisecond := duration / time.Millisecond
	return fmt.Sprintf(`%02d:%02d:%02d,%03d`, hour, minute, second, millisecond)
}

func readOneSubtitle(scanner *bufio.Scanner) (*Subtitle, error) {
	// read idx
	if !scanner.Scan() {
		return nil, nil
	}
	idxRaw := scanner.Text()
	idx, err := strconv.Atoi(idxRaw)
	if err != nil {
		return nil, errors.New("invalid subtitle index")
	}
	// read timing
	if !scanner.Scan() {
		return nil, errors.New("could not find subtitle timing")
	}
	timing := timeFramePattern.FindStringSubmatch(scanner.Text())
	if timing == nil {
		return nil, errors.New("invalid subtitle timing")
	}
	fromTime := getDuration(timing[1:5])
	toTime := getDuration(timing[5:9])
	// read content
	if !scanner.Scan() {
		return nil, errors.New("could not find subtitle text")
	}
	content := scanner.Text()
	for scanner.Scan() && scanner.Text() != "" {
		content += "\n"
		content += scanner.Text()
	}
	subtitle := &Subtitle{idx, fromTime, toTime, content}
	return subtitle, nil
}

func writeOneSubtitle(file io.Writer, subtitle *Subtitle, idx *int) error {
	_, err := fmt.Fprint(file,
		*idx, "\n",
		printDuration(subtitle.fromTime), " --> ", printDuration(subtitle.toTime), "\n",
		subtitle.text, "\n\n")
	*idx++
	return err
}

func main() {
	//if len(os.Args) < 2 {
	//	println("Provide a subtitle file to fix.\ne.g. subtitle-fixer mysubtitle.srt")
	//	return
	//}

	//filePath := os.Args[1]
	//filePath := "subtitle-fixer/Learn_Hypnosis_Direct.srt"
	//filePath := "subtitle-fixer/The.Simpsons.s17e01.srt"
	filePath := "subtitle-fixer/Learn_Hypnosis_Direct_ascii.srt"
	newFilePath := filePath + ".fixed"

	file, err := os.Open(filePath)
	if err != nil {
		log.Fatalf("error: %s", err)
	}

	newFile, _ := os.Create(newFilePath)
	defer file.Close()
	defer newFile.Close()

	scanner := bufio.NewScanner(file)
	var newIdx = 1
	var lastSubtitle *Subtitle = nil

	for {
		subtitle, err := readOneSubtitle(scanner)
		if lastSubtitle != nil {
			if subtitle != nil {
				subtitle.text = strings.Trim(subtitle.text, "\n ")
				if len(subtitle.text) == 0 { // skip over empty subtitles
					continue
				}
				// skip over super-short subtitles that basically contain what their previous subtitle contains, and just prolong previous subtitle
				if subtitle.toTime-subtitle.fromTime < time.Millisecond*150 &&
					strings.Contains(lastSubtitle.text, subtitle.text) {
					lastSubtitle.toTime = subtitle.toTime
					continue
				}
				// if first-line of current subtitle is repeating last-line of previous-subtitle remove it
				currentLines := strings.Split(subtitle.text, "\n")
				lastLines := strings.Split(lastSubtitle.text, "\n")
				if currentLines[0] == lastLines[len(lastLines)-1] {
					subtitle.text = strings.Join(currentLines[1:], "\n")
				}
				// if first-line of current subtitle is repeating last-line of previous-subtitle remove it
				if subtitle.fromTime < lastSubtitle.toTime {
					lastSubtitle.toTime = subtitle.fromTime - time.Millisecond
				}
			}
			writeOneSubtitle(newFile, lastSubtitle, &newIdx)
		}
		if subtitle == nil {
			break
		}
		if err != nil {
			panic(err)
		}
		lastSubtitle = subtitle
	}

	os.Rename(filePath, filePath+".bak")
	os.Rename(newFilePath, filePath)
}
