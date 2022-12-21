package part01;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "Aabb";

        frequencySort(s1);
        frequencySort(s2);
    }

    static String frequencySort(String s) {
        Map<String, Integer> frequency = new HashMap<>();
        Map<String, Integer> frequencyOrdered = new LinkedHashMap<>();

        for (String l : s.split("")) {
            frequency.put(l, frequency.getOrDefault(l, 0) + 1);
        }

        frequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> frequencyOrdered.put(x.getKey(), x.getValue()));

        List<String> finalWord = new ArrayList<>();

        for (String k : frequencyOrdered.keySet()) {
            int count = frequencyOrdered.get(k);
            while (count > 0) {
                finalWord.add(k);
                count--;
            }
        }
        return String.join("", finalWord);
    }
}
