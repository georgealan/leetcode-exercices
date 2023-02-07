package part01;

import java.util.Stack;

/*
TODO Leetcode exercise 155. Min Stack
 */
public class MinStack {
    Stack<Integer> sk = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        sk.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }

    public void pop() {
        int pop = sk.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return sk.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
         MinStack obj = new MinStack();
         obj.push(1);
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin();


    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
