package leetcode75.yandex.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class D {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    reader.close();
    writer.close();
  }

  public void a(List<Integer> nums) {
    int l = 0;
    int r = nums.size() - 1;
    int[] prefix = new int[r + 2];
    for (int i : nums) {
      prefix[i + 1] = prefix[i] + i;
    }
    int Sl = 0;
    int Sr = 0;
    int min = Integer.MAX_VALUE;
    while (l < r) {
      if (Sl < Sr) {
        l++;
      } else {
        r++;
      }
    }
    // 1 3 4 5
    // 1 2 4 5
  }
}
