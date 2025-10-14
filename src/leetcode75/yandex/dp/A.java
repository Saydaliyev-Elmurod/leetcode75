package leetcode75.yandex.dp;

import java.io.*;

public class A {
  public static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    dp = new int[n + 1];
    int res = calculatePath(n);
    writer.write(String.valueOf(res));
    reader.close();
    writer.close();
  }

  private static int calculatePath(int n) {
    // 4-3 4-2 4-1
    // 3-2 3-1 3-0
    // 2-1 2-0
    // 1-0
    if (dp[n] != 0) return dp[n];
    if (n == 3) return 4;
    if (n == 2) return 2;
    if (n == 1) return 1;
    if (n == 0) return 0;
    int path = calculatePath(n - 1) + calculatePath(n - 2) + calculatePath(n - 3);
    dp[n] = path;
    return path;
  }
}
