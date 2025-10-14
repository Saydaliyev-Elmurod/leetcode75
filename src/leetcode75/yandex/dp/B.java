package leetcode75.yandex.dp;

import java.io.*;

public class B {
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = reader.readLine();
    dp = new int[2][line.length() + 1];
    int res = calculateMove(line, true);
    writer.write(String.valueOf(res));
    reader.close();
    writer.close();
  }

  private static int calculateMove(String line, boolean isLeft) {
    if (line.isEmpty()) return 0;
    char first = line.charAt(0);
    if (line.length() == 1) {
      if (first == 'L') { // L  //R
        if (isLeft) {
          return 1;
        } else {
          return 0;
        }
      } else {
        return 1;
      }
    }
    // first child in Left
    int move;
    if (isLeft && dp[0][line.length()] != 0) {
      return dp[0][line.length()];
    } else if (!isLeft && dp[1][line.length()] != 0) {
      return dp[1][line.length()];
    }

    if (isLeft) {
      if (first == 'L') {
        move =
            Math.min(
                calculateMove(line.substring(1), true) + 1,
                calculateMove(line.substring(1), false) + 1);
      } else if (first == 'R') {
        move =
            Math.min(
                calculateMove(line.substring(1), true),
                calculateMove(line.substring(1), false) + 2);
      } else {
        move =
            Math.min(
                calculateMove(line.substring(1), true) + 1,
                calculateMove(line.substring(1), false) + 2);
      }
    } else {
      // second child in Right
      if (first == 'L') {
        move =
            Math.min(
                calculateMove(line.substring(1), false),
                calculateMove(line.substring(1), true) + 2);
      } else if (first == 'R') {
        move =
            Math.min(
                calculateMove(line.substring(1), true) + 1,
                calculateMove(line.substring(1), false) + 1);
      } else {
        move =
            Math.min(
                calculateMove(line.substring(1), true) + 2,
                calculateMove(line.substring(1), false) + 1);
      }
    }
    if (isLeft) {
      dp[0][line.length()] = move;
    } else {
      dp[1][line.length()] = move;
    }
    return move;
  }
}
