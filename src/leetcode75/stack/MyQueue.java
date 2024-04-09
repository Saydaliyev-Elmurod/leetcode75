package leetcode75.stack;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reverseStack;

    public MyQueue() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        reverseStack.clear();
        reverseStack.addAll(stack);
        stack.clear();
        stack.push(x);
        stack.addAll(reverseStack);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}