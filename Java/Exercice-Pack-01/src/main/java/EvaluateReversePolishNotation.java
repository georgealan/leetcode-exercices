import java.util.Stack;

/*
TODO Leetcode exercise: 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens1 = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int result1 = evalRPNSolutionOne(tokens1);
        System.out.println(result1);

        int result2 = evalRPNSolutionTwo(tokens1);
        System.out.println(result2);
    }

    public static int evalRPNSolutionOne(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int eval(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static int evalRPNSolutionTwo(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        int a, b;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    a = s.pop();
                    b = s.pop();
                    s.push(b + a);
                    break;
                case "-":
                    a = s.pop();
                    b = s.pop();
                    s.push(b - a);
                    break;
                case "*":
                    a = s.pop();
                    b = s.pop();
                    s.push(b * a);
                    break;
                case "/":
                    a = s.pop();
                    b = s.pop();
                    s.push(b / a);
                    break;
                default:
                    s.push(Integer.parseInt(t));
                    break;
            }
        }
        return s.pop();
    }
}
