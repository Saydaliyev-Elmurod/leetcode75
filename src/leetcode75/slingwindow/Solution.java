package leetcode75.slingwindow;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max;
        int left = 0;
        int usedCount = 0;
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < k && i < nums.length; i++) {
            if (nums[i] == 0) {
                used[i] = true;
                usedCount++;
            }
        }
        max = k;
        int right = k;
        while (right < nums.length) {
            if (nums[right] == 1) {
                max++;
            } else {
                if (usedCount < k) {
                    used[right] = true;
                    usedCount++;
                    max++;
                    if (used[left]) {
                        usedCount--;
                        left++;
                    }
                }
            }
            right++;
        }
        return max;
    }
}