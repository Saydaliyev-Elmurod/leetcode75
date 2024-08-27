package leetcode75.twopointer;
//https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public static void main(String[] args) {
        findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1);
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int temp = sum;
        for (int i = k; i < nums.length; i++) {
            temp = temp + nums[i] - nums[i - k];
            sum = Math.max(sum, temp);
        }
        return (double) sum / k;
    }
}