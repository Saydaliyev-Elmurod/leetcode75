package leetcode75.problems.containerwithmostwater;

class Solution {
    //https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
    public int maxArea(int[] height) {
        //[1,8,6,2,5,4,8,3,7]
        // it is work but O(n^2)
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int minHeight = Math.min(height[i], height[j]);
//                max = Math.max(max, (j - i) * minHeight);
//            }
//        }
//        return max;

        // we use two pointer
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}