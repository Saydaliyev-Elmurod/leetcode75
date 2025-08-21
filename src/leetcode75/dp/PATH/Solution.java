package leetcode75.dp.PATH;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public static void main(String[] args) {
    System.out.println(uniquePaths(100, 100));
  }

  public static int uniquePaths(int m, int n) {
    if (m == 0 || n == 0) return 0;
    if (m == 1 || n == 1) return 1;
    //  1 1 1
    //  1 1 1
    int[][] dp = new int[m + 1][n + 1];
    int first = dp[m][n - 1];
    int second = dp[m - 1][n];
    if (first == 0) {
      first = uniquePaths(m, n - 1);
      dp[m][n - 1] = first % 2_000_000_000;
    }
    if (second == 0) {
      second = uniquePaths(m - 1, n);
      dp[m - 1][n] = second % 2_000_000_000;
    }
    return (first % 2_000_000_000 + second % 2_000_000_000) % 2_000_000_000;
  }
}
