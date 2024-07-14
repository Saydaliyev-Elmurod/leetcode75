package leetcode75.problems.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (a + b > 0) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    if (a + b + c > 0) {
                        break;
                    }
                    if (a + b + c == 0) {
                        List<Integer> list = List.of(a, b, c);
                       if (result.contains(list)){
                           result.add(list);
                       }
                    }
                }
            }
        }
        return result;
    }
}