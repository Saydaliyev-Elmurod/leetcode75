package leetcode75.design.kthlargest;

import java.util.Arrays;
import java.util.Stack;

class KthLargest {
    int k;
    Stack<Integer> stack;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.add(nums[nums.length - 1 - i]);
        }
    }

    public int add(int val) {
        Integer peek = stack.peek();
        if (peek < val) {
            stack.pop();
            stack.add(val);
            return val;
        }
        return k;
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */