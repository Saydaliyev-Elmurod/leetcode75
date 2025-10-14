package leetcode75.yandex;

import java.io.*;

public class Nine {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] line1 = reader.readLine().split(" ");
    long x = Long.parseLong(line1[0]);
    long y = Long.parseLong(line1[1]);
    String[] line2 = reader.readLine().split("\\s+");
    long f = Long.parseLong(line2[0]);
    long g = Long.parseLong(line2[1]);
    long dx = Math.abs(x - f);
    long dy = Math.abs(y - g);
    long res;
    if (dx == 0 && dy == 0) {
      res = 0L;
    } else if (dx == 0) {
      res = (long) 3 * (dy - 1);
    } else if (dy == 0) {
      res = (long) 3 * (dx - 1);
    } else {
      long disX = dx + (dx - 1) * 2L;
      long disY = dy + (dy - 1) * 2L;
      res = disX + disY - 1;
    }
    writer.write(String.valueOf(res));
    reader.close();
    writer.close();
  }
}
