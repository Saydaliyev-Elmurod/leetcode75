package leetcode75.design.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    Integer min;
    List<Integer> stack;
    List<Integer> minElements;

    public MinStack() {
        min = 0;
        stack = new ArrayList<>();
        minElements = new ArrayList<>();
    }


    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, min);
        }
        stack.add(val);
        minElements.add(min);
    }


    public void pop() {
        int size = minElements.size();
        stack.remove(size - 1);
        minElements.remove(size - 1);
        if (size != 1) {
            min = minElements.get(size - 2);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minElements.get(minElements.size() - 1);
    }
}

