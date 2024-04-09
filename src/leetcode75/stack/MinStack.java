//package leetcode75.stack;
//
//import java.util.*;
//
//class MinStack {
//    int min;
//    Stack<Integer> stack;
//
//    /**
//     * STackni implementaion qilish kerak lekin har doim minimal
//     * qiymatni olish imkoni bolishi kerak
//     */
//
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        if (stack.isEmpty()) {
//            min = x;
//
//        } else {
//            stack.push(x);
//            if (min > x) min = x;
//        }
//    }
//
//    public void pop() {
//        if (stack.isEmpty()) return;
//        int pop = stack.pop();
//        if (pop == min) {
//
//        }
//    }
//
//    public int top() {
//
//    }
//
//    public int getMin() {
//    }
//}