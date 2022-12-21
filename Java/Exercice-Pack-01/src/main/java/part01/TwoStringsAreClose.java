package part01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "xxzzbbz", word2 = "bbbzzxx";    // true
        String word3 = "xxzzbbz", word4 = "bbbzzyy";    // false
        String word5 = "cabbba", word6 = "abbccc";      // true
        String word7 = "cbbbba", word8 = "abbccc";      // false
        String word9 = "a", word10 = "aa";              // false

        closeStrings(word1, word2);
        closeStrings(word3, word4);
        closeStrings(word5, word6);
        closeStrings(word7, word8);
        closeStrings(word9, word10);
    }

    static boolean closeStrings(String word1, String word2) {
        boolean hasSameLength = word1.length() == word2.length();
        Map<String, Integer> l1 = new HashMap<>();
        Map<String, Integer> l2 = new HashMap<>();

        if (hasSameLength) {
            Set<String> letters1 = Arrays.stream(word1.split(""))
                    .collect(Collectors.toCollection(TreeSet::new));

            Set<String> letters2 = Arrays.stream(word2.split(""))
                    .collect(Collectors.toCollection(TreeSet::new));

            if (letters1.containsAll(letters2) && letters2.containsAll(letters1)) {
                for (String s : word1.split("")) {
                    l1.put(s, l1.getOrDefault(s, 0) + 1);
                }
                for (String s : word2.split("")) {
                    l2.put(s, l2.getOrDefault(s, 0) + 1);
                }

                List<Integer> v1 = new ArrayList<>(l1.values());
                List<Integer> v2 = new ArrayList<>(l2.values());
                Collections.sort(v1);
                Collections.sort(v2);

                return v1.equals(v2);
            }
        }
        return false;
    }
}
