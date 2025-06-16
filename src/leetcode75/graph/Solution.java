package leetcode75.graph;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void rotate(int[] nums, int k) {
        // 1,2,3,4,5,6 2
        // 3,4,5,6,1,2
        k = k % nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-k; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length-k; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
}