package leetcode75.hashMapSet.longestrepeating;

import javax.print.DocFlavor;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 1, 2, 5};
        int k = 2;
        System.out.println(solution.partitionArray(nums, k)); // Output: 2
        nums = new int[]{2,2,4,5};
        k = 0;
        System.out.println(solution.partitionArray(nums, k)); // Output: 3
    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                ans++;
                start = nums[i];
            }
        }
        return ans;
    }
}