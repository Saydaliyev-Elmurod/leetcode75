package leetcode75.problems.productOfArray;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        boolean existZero = false;
        boolean doubleZero = false;
        for (int num : nums) {
            if (num != 0) {
                sum *= num;
            } else {
                if (existZero) {
                    doubleZero = true;
                }
                existZero = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (doubleZero) {
                nums[i] = 0;
            } else if (nums[i] == 0) {
                nums[i] = sum;
            } else if (existZero) {
                nums[i] = 0;
            } else {
                nums[i] = sum / nums[i];
            }
        }
        return nums;
    }
}