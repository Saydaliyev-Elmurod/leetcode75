package leetcode75.slingwindow.minimumsubarray;

class Solution {
    //https://leetcode.com/problems/minimum-size-subarray-sum/editorial/?envType=study-plan-v2&envId=top-interview-150

    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{1, 2, 3, 4});
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}