package leetcode75.daySolutions.may27;

import java.util.*;

class Solution {
    /**
     * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
     */
    public int specialArray(int[] nums) {
        // shunday x soni topilishi kerak shu arrayda shu x dan x ta teng yoki undan katta son bolishi kerak
        int last = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int i1 = nums.length - i;
            if (i1 == nums[i] && last != nums[i]) {
                return nums[i];
            }
            last = nums[i];
        }
        return -1;
    }
}