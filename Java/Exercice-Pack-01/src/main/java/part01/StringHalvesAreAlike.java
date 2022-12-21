package part01;

import java.util.stream.Stream;

public class StringHalvesAreAlike {
    public static void main(String[] args) {
        halvesAreAlike("BOOK");
        halvesAreAlike("textbook");

    }

    static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        boolean isVowel;
        int countA = 0;
        int countB = 0;
        int splitInHalf = s.length() / 2;
        String regex = "[aeiou]+";
        char[] a = s.substring(0, splitInHalf).toCharArray();
        char[] b = s.substring(splitInHalf).toCharArray();


        for (int i = 0; i < splitInHalf; i++) {
            String chr1 = String.valueOf(a[i]);
            isVowel = chr1.matches(regex);
            if (isVowel) {
                countA++;
            }
            String chr2 = String.valueOf(b[i]);
            isVowel = chr2.matches(regex);
            if (isVowel) {
                countB++;
            }
        }

        // Only for visualise results.
        if (countA == countB) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        return countA == countB;
    }
}


/*
 * Methods to use:
 * substring()
 * length()
 * /[aeiou]+/
 */