import java.util.ArrayDeque;

/*
TODO Leetcode exercise: 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks {

}

class MyQueue {
    private final ArrayDeque<Integer> inputbuf;
    private final ArrayDeque<Integer> output;

    public MyQueue() {
        inputbuf = new ArrayDeque<Integer>();
        output = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inputbuf.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!inputbuf.isEmpty()) {
                output.push(inputbuf.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return inputbuf.isEmpty() && output.isEmpty();
    }
}
