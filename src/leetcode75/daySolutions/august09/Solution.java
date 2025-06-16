package leetcode75.daySolutions.august09;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            if (validate(i, grid, sum)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean validate(final int i, final int[][] grid, final int sum) {
        return false;
    }
}