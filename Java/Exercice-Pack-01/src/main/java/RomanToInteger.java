import java.util.*;

public class RomanToInteger {
    static int sumResult = 0;
    static int listIteration = 0;
    static int oldListValue = 0;
    static int iterator = 0;
    static List<Character> romamLetters = new LinkedList<>();
    static LinkedHashMap<String, Integer> romamNumbers = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String romanNumber = scanner.nextLine().toUpperCase();

        fill(romamNumbers);
        int conversionResult = romanNumberToInteger(romanNumber);
        System.out.println(conversionResult);
    }

    private static int romanNumberToInteger(String s) {
        fill(romamLetters, s);
        ListIterator<Character> it = romamLetters.listIterator();
        final int firstNumber = romamNumbers.get(it.next().toString());

        while (it.hasNext()) {
            listIteration = romamNumbers.get(it.next().toString());

            if (firstNumber < listIteration) {
                iterator = listIteration - firstNumber;
                sumResult += iterator;
            }

            if (firstNumber >= listIteration) {
                oldListValue = listIteration;
                listIteration = romamNumbers.get(it.next().toString());

                if (oldListValue < listIteration) {
                    iterator = listIteration - oldListValue;
                    sumResult += iterator;
                }

                if (oldListValue >= listIteration) {
                    iterator = oldListValue + listIteration;
                    sumResult += iterator;
                }
            }
        }

        if (romamLetters.size() == 1) {
            return firstNumber;
        }

        return sumResult;
    }

    static Map fill(Map<String, Integer> map) {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }

    static List fill(List<Character> list, String s) {
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        return list;
    }
}
