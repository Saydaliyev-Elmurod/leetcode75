package leetcode75.leetcode150.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //
        int low, high = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = nums[i];
            if (temp > 0) {
                break;
            }
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                if (temp + nums[low] + nums[high] > 0) {
                    high--;
                } else if (temp + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    list.add(temp);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                }
            }
        }
        return res;

    }
}