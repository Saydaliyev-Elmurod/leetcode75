package leetcode75.yandexContest.january;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class B {
    static int count = 0;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] rowColumn = reader.readLine().split(" ");
        int n = Integer.parseInt(rowColumn[0]);
        int b = Integer.parseInt(rowColumn[1]);
        String[] arr = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int left = 0;
        int right = 0;
        int bIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < b) {
                left++;
            } else if (nums[i] > b) {
                right++;
            } else {
                bIndex = i;
            }
        }
        backtrack(nums, left, right, bIndex, 0, n - 1);
        writer.write(String.valueOf(count));
        writer.close();
        reader.close();
    }

    public static void backtrack(int[] nums, int left, int right, int bIndex, int leftIndex, int rightIndex) {
        if (leftIndex > bIndex || rightIndex < bIndex) {
            return;
        }
        if (left == right) {
            if (!set.contains(leftIndex + " " + rightIndex)) {
                count++;
                set.add(leftIndex + " " + rightIndex);
            }
        }
        if (nums[leftIndex] > nums[bIndex]) {
            backtrack(nums, left, right - 1, bIndex, leftIndex + 1, rightIndex);
        } else {
            backtrack(nums, left - 1, right, bIndex, leftIndex + 1, rightIndex);
        }
        if (nums[rightIndex] > nums[bIndex]) {
            backtrack(nums, left, right - 1, bIndex, leftIndex, rightIndex - 1);
        } else {
            backtrack(nums, left - 1, right, bIndex, leftIndex, rightIndex - 1);
        }
    }

}

