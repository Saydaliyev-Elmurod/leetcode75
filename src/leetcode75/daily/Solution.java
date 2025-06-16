
package leetcode75.daily;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSymmetricIntegers(1200, 1230));
    }

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if ((i + "").length() % 2 == 1) continue;
            final char[] arr = (i + "").toCharArray();
            int left = 0;
            int right = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < arr.length / 2) {
                    left += arr[j] - '0';
                } else {
                    right += arr[j] - '0';
                }
            }
            if (left == right) {
                count++;
            }
        }
        return count;
    }
}