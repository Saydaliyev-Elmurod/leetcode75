package leetcode75.daySolutions.june17;

class Solution {
    public boolean judgeSquareSum2(int c) {
        for (int i = 0; i * i < c; i++) {
            double sqrt = Math.sqrt(c - i * i);
            if (sqrt == (int) sqrt) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        for (int i = 0; i * i < c; i++) {
            for (int j = 0; j * j < c; j++) {
                if (j * j + i * i == c) {
                    return true;
                }
            }
        }
        return false;
    }
}