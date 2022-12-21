package part01;

import java.util.*;
import java.util.stream.IntStream;

/*
TODO Leetcode exercise: 682. Baseball Game
 */
public class BaseballGame {
    public static void main(String[] args) {
        String[] ops1 = {"5","2","C","D","+"};
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        String[] ops3 = {"1","C"};

        int result1 = calPoints(ops1);
        System.out.println("The points of result1 is = " + result1);

        int result2 = calPoints(ops2);
        System.out.println("The points of result1 is = " + result2);

        int result3 = calPoints(ops3);
        System.out.println("The points of result1 is = " + result3);
    }
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>(); // The Stack class represents a last-in-first-out (LIFO) stack of objects.
        int top = 0;
        int newTop = 0;
        int result = 0;

        for (String obj : operations) {
            if (obj.equals("+")) {
                top = stack.pop(); // It's for remove, but the value is stored in return of this function, can be used posteriorly.
                newTop = top + stack.peek(); // The result of top will be summed with the top object of this stack.
                stack.push(top);
                stack.push(newTop);
            } else if (obj.equals("C")) {
                stack.pop();
            } else if (obj.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.parseInt(obj));
            }
        }

        for (int n : stack) {
            result += n;
        }
        return result;
    }
}
