package leetcode75.yandex.dp;

import java.io.*;
import java.util.*;

public class G {
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    dp = new int[n + 1][n + 1];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      int canCreate = isCanCreate(n - i, i);
      sum += canCreate;
    }
    writer.write(String.valueOf(sum));
    reader.close();
    writer.close();
  }

  private static int isCanCreate(int cube, int prev) {
    int res = 0;
    if (cube > 0 && dp[prev][cube] != 0) {
      return dp[prev][cube];
    }
    if (cube == 0) {
      res++;
    }
    for (int i = 1; i < prev && cube > 0; i++) {
      res += isCanCreate(cube - i, i);
    }
    if (cube > 0) {
      dp[prev][cube] = res;
    }
    return res;
  }
}
