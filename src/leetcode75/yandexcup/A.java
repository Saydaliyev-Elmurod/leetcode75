package leetcode75.yandexcup;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

// 2023 `Yandex Cup - Qualification Round A
public class A {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] first = reader.readLine().split(" ");
    int m = Integer.parseInt(first[0]);
    int n = Integer.parseInt(first[1]);
    String[] arr = reader.readLine().split(" ");
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(arr[i]);
    }
    int[] prefix = new int[n];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }
    // 10 12 1 2 3
    int sum = 0;
    List<Integer> add = new LinkedList<>();
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] != 0) {
      }
    }
    writer.write(sum + "");
    writer.close();
    reader.close();
  }
}
