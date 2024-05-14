package leetcode75.search;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    private int binarySearch(final int[] nums, final int target, int low, int high) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            high = mid;
            return binarySearch(nums, target, low, high);
        } else {
            low = mid;
            return binarySearch(nums, target, low, high);
        }

    }
}