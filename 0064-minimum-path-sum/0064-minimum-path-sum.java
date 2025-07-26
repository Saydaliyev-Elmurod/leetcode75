class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        int n = grid.length - 1;
        int m = grid[0].length - 1;
        return grid[n][m] + path(grid, n, m);
    }

    public int path(int[][] grid, int n, int m) {
        if (dp[n][m] != -1)
            return dp[n][m];
        if (n < 1) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[n][i];
            }
            return sum;
        }
        if (m < 1) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += grid[i][m];
            }
            return sum;
        }
        int first = grid[n][m - 1] + path(grid, n, m - 1);
        int second = grid[n - 1][m] + path(grid, n - 1, m);
        dp[n][m] = Math.min(first, second);
        return dp[n][m];
    }
}