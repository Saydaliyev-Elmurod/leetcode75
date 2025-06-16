package leetcode75.yandex.uzbcup;

import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        final int s1 = Integer.parseInt(reader.readLine());
        final String[] lines = reader.readLine().split(" ");
        int[] nums = new int[s1];
        for (int i = 0; i <= lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        int counter = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int max = Math.max(nums[i], nums[i+1]);

        }
        writer.close();
        reader.close();
    }
}
