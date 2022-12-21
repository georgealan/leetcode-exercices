package part01;

/*
TODO Leetcode exercise: 20. Valid Parentheses
*/
public class ValidParentheses {
    public static void main(String[] args) {
        String input1 = "()";
        String input2 = "()[]{}";
        String input3 = "(]";
        String input4 = "()[]{}[)}{}]";
        String input5 = "{[]}";
        String input6 = "[{[]}]"; // True, have to be close at same level.
        String input7 = "]{[]}["; // False, count per same chars won't work.
        String input8 = "[}][{]"; // False too

        boolean result1 = isValidFirstAproach(input5);
        System.out.println(result1);
    }

    public static boolean isValid(String s) {
        String[] groupChars = s.split("(?<=\\G.{2})");


        return true;
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
