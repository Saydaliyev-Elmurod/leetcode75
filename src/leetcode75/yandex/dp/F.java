package leetcode75.yandex.dp;

import java.io.*;
import java.util.*;

public class F {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    List<String> list = new ArrayList<>();
    while (n-- > 0) {
      list.add(reader.readLine());
    }

    int size = list.size();
    int[][] dp = new int[size][3];
    String first = list.getFirst();
    if (first.equals("WWW")) {
      writer.write("0");
      reader.close();
      writer.close();
      return;
    }
    dp[0][0] = first.charAt(0) == 'C' ? 1 : first.charAt(0) == 'W' ? -1 : 0;
    dp[0][1] = first.charAt(1) == 'C' ? 1 : first.charAt(1) == 'W' ? -1 : 0;
    dp[0][2] = first.charAt(2) == 'C' ? 1 : first.charAt(2) == 'W' ? -1 : 0;
    for (int i = 1; i < size; i++) {
      String line = list.get(i);
      if (line.equals("WWW")
          || (line.startsWith("WW") && list.get(i - 1).endsWith("WW"))
          || (line.endsWith("WW") && list.get(i - 1).startsWith("WW"))) {
        writer.write(String.valueOf(Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]))));
        reader.close();
        writer.close();
        return;
      }
      char ch1 = line.charAt(0);
      int max1 = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][0] = ch1 == 'W' || max1 == -1 ? -1 : ch1 == 'C' ? (max1 + 1) : max1;
      int max2 = Math.max(dp[i - 1][1], dp[i - 1][2]);
      char ch2 = line.charAt(2);
      dp[i][2] = ch2 == 'W' || max2 == -1 ? -1 : ch2 == 'C' ? (max2 + 1) : max2;
      int max3 = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
      char ch3 = line.charAt(1);
      dp[i][1] = ch3 == 'W' || max3 == -1 ? -1 : ch3 == 'C' ? (max3 + 1) : max3;
      if (dp[i][0] == -1 && dp[i][1] == -1 && dp[i][2] == -1) {
        writer.write(String.valueOf(Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]))));
        reader.close();
        writer.close();
        return;
      }
    }
    writer.write(
        String.valueOf(Math.max(dp[size - 1][0], Math.max(dp[size - 1][1], dp[size - 1][2]))));
    reader.close();
    writer.close();
  }
}
