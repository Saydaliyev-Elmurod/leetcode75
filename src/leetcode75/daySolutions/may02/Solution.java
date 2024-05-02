package leetcode75.daySolutions.may02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int findMaxK(int[] nums) {
        int result = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.contains(-1 * num)) {
                result = Math.max(result, Math.abs(num));
            }
        }
        return result;
    }
}