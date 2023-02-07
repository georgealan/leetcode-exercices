package part01;

import java.util.ArrayList;
import java.util.Arrays;

/*
TODO Leetcode exercise: 20. Valid Parentheses
*/
public class ValidParentheses {
    static ArrayList<String> group = new ArrayList<>();
    public static void main(String[] args) {
        String input1 = "()";
        String input2 = "()[]{}";
        String input3 = "(]";
        String input4 = "()[]{}[)}{}]";
        String input5 = "{[]}";
        String input6 = "[{[]}]"; // True, have to be close at same level.
        String input7 = "]{[]}["; // False, count per same chars won't work.
        String input8 = "[}][{]"; // False too

//        boolean result1 = isValidFirstAproach(input5);
//        boolean result2 = isValid(input6);
        boolean result4 = isValid(input5);
//        boolean result3 = isValid(input2);
        System.out.println(result4);
//        System.out.println(result3);

        char compare = '[';
        char test = 93;
        System.out.println("Character using code ascii: " + test);
        if (test == compare) {
            System.out.println("Charachters are equals!");
        }
    }

    public static boolean isValid(String s) {
        int lenght = s.length();
        String regex = "(?<=\\G.{" + 2 + "})";
        System.out.println("Lenght of string: " + lenght);
        String[] groupChars = s.split(regex);
        System.out.println("ArrayList before fill: " + group);
        group = fillArrayList(groupChars);
        System.out.println("ArrayList before: " + group);
//        String[] groupChars = s.split("");
        //                System.out.println("Match: " + oneChar);
        group.removeIf(oneChar -> oneChar.matches("((?:\\[])|(?:\\{})|(?:\\()\\))"));

        System.out.println("ArrayList after matchs: " + group);


        return true;
    }

    static ArrayList<String> fillArrayList(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String oneChar : array) {
            arrayList.add(oneChar);
        }
        return arrayList;
    }

    public static boolean isValidFirstAproach(String s) {
        // Split in group of two characters, ex: ["()", "[]", "{)"]
        String[] groupChars = s.split("(?<=\\G.{2})");

        for (String oneChar : groupChars) {
            if (!oneChar.matches("((?:\\[])|(?:\\{})|(?:\\()\\))")) {
                return false;
            }
        }
        return true;
    }
}

/*
 ASCII Table for [] {} ()
    ( = 40
    ) = 41
    [ = 91
    ] = 93
    { = 123
    } = 125
 */