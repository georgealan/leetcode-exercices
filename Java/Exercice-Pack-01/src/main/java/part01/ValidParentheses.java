package part01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
TODO Leetcode exercise: 20. Valid Parentheses
*/
public class ValidParentheses {
//    static ArrayList<String> group = new ArrayList<>();
    public static void main(String[] args) {
        String input1 = "()";
        String input2 = "()[]{}";
        String input3 = "(]";
        String input4 = "()[]{}[)}{}]";
        String input5 = "{[]}";
        String input6 = "[{[]}]"; // True, have to be close at same level.
        String input7 = "]{[]}["; // False, count per same chars won't work.
        String input8 = "[}][{]"; // False too

        boolean result = isValid(input8);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if (s.isBlank() || s.isEmpty()) { return false; }
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char specialChar = s.charAt(i);

            if (specialChar == '(' || specialChar == '{' || specialChar == '[') {
                characters.push(specialChar);
            } else if (specialChar == ')' || specialChar == '}' || specialChar == ']') {
                if (characters.isEmpty()) { return false; }

                char pop = characters.pop();
                if (!isValid(pop, specialChar)) { return false; }
            } else {
                return false;
            }
        }
        return characters.isEmpty() ? true : false;
    }

    public static boolean isValid(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }


    /*
    FIRST TRY:
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

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.isBlank()) { return false; }

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

        String rest = String.join("", group);
        System.out.println("String rest: " + rest);

        groupChars = rest.split("");
        group = fillArrayList(groupChars);
        System.out.println("New ArrayList values: " + group);

        return true;
    }
     */
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