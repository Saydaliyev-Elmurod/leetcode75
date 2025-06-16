package leetcode75.daySolutions.aprel24;

class Solution {
    public int tribonacci(int n) {
        if (n > 3) {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        } else if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 1;
        else if (n == 3) return 2;
        return 0;
    }

    public int tribonacci2(int n) {
        int[] arr = new int[n + 1];
        if (n < 3) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 1;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];

    }


}