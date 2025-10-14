package leetcode75.yandex.dp;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class C {
  public static boolean[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = reader.readLine();
    int n = Integer.parseInt(reader.readLine());
    Set<String> set = new HashSet<>();
    while (n-- > 0) {
      String item = reader.readLine();
      set.add(item);
    }
    // whaticando
    int[] prev = new int[line.length()];
    prev[0] = 0;
    Map<Integer, String> map = new LinkedHashMap<>();
    dp = new boolean[line.length() + 1];
    dp[0] = true;
    for (int i = 0; i < line.length(); i++) {
      for (int j = 0; j <= i; j++) {
        String next = line.substring(j, i + 1);
        if (dp[j] && set.contains(next)) {
          dp[i + 1] = true;
          map.put(j, next);
          break;
        }
      }
    }

    writer.write(String.join(" ", map.values()));
    reader.close();
    writer.close();
  }
}
