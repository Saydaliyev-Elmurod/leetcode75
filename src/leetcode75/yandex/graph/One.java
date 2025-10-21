package leetcode75.yandex.graph;

import java.io.*;

public class One {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] line1 = reader.readLine().split(" ");
    long a = Long.parseLong(line1[0]);
    long b = Long.parseLong(line1[1]);
    long c = Long.parseLong(line1[2]);
    // (l-b)(l-a) =c l2-al-bl+ba=c l2-(a+b)l+ba-c=0;
    long d = a * a + b * b - 2 * a * b + 4 * c;
    long res = -1;
    long sqrtD = (long) Math.sqrt(d);
    if (sqrtD * sqrtD == d) {
      long x1 = (a + b + sqrtD) / 2;
      long x2 = (a + b - sqrtD) / 2;

      if (x1 > a && x1 > b && (x1 - a) * (x1 - b) == c) res = x1;
      else if (x2 > a && x2 > b && (x2 - a) * (x2 - b) == c) res = x2;
    }
    writer.write(String.valueOf(res));
    reader.close();
    writer.close();
  }
}
