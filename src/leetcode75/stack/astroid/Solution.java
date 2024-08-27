package leetcode75.stack.astroid;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                Integer peek = stack.pop();
                if (peek > asteroid) {
                    stack.push(peek);
                } else if (peek < asteroid) {
                   while (!stack.isEmpty()){
                       Integer pop = stack.pop();
//                       if (pop>asteroid)
                   }
                }
            }
        }
        return null;
    }
}