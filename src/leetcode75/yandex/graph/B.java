package leetcode75.yandex.graph;

import java.io.*;
import java.util.Arrays;

public class B {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] line = reader.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int p = Integer.parseInt(line[1]);
    String[] arr = reader.readLine().split(" ");
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(arr[i]);
    }
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    int first = 0;
    int second = 0;
    for (int i = 0; i < n; i++) {
      int curr = nums[i];
      if (curr > p) {
        break;
      }
      int left = i;
      int right = n - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] / curr < p) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
        if (min > curr - nums[mid]) {
          min = curr - nums[mid];
          first = i + 1;
          second = mid + 1;
        }
      }
    }
    System.out.println(min);
    writer.write(first + " " + second);
    reader.close();
    writer.close();
  }
}
