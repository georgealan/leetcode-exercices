import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "Aabb";

        frequencySort(s1);
        frequencySort(s2);
    }

    static String frequencySort(String s) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String l : s.split("")) {
            frequency.put(l, frequency.getOrDefault(l, 0) + 1);
        }
        System.out.println(frequency);


        return "";
    }
}
