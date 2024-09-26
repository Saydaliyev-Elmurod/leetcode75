package leetcode75.leetcode150;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        summaryRanges(new int[]{1, 2, 3, 5, 6, 9});
    }

    public static List<String> summaryRanges(int[] nums) {
        int start = nums[0];
        List<String> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (start != nums[i - 1]) {
                    list.add(start + "->" + nums[i - 1]);
                } else {
                    list.add(start + "");
                }
                start = nums[i];
            }
        }
        if (start != nums[nums.length - 1]) {
            list.add(start + "->" + nums[nums.length - 1]);
        } else {
            list.add(nums[nums.length - 1] + "");
        }
        return list;
    }
}