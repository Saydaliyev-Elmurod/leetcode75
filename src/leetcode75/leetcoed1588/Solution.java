package leetcode75.leetcoed1588;

class Solution {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        // 1,4,2,5,3
        int sum = 0;
        int[] sumArr = new int[arr.length + 1];
        sumArr[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr[i + 1] = sumArr[i] + arr[i];
        }
        int left = 0;
        int right = 0;
        while (left <= right && right < arr.length) {
            if (left == right) {
                sum += arr[left];
            } else {
                sum += sumArr[right + 1] - sumArr[left];
            }
            right += 2;
            if (right >= arr.length) {
                left++;
                right = left;
            }
        }
        return sum;
    }
}