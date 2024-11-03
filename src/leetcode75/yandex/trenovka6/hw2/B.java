package leetcode75.yandex.trenovka6.hw2;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        //5 17
        //10 7 10 7 10 17 10 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] string = reader.readLine().split(" ");
        int n = Integer.parseInt(string[0]);
        int k = Integer.parseInt(string[1]);
        String[] arr = reader.readLine().split(" ");
        int count = 0;

        int[] sumArr = new int[n];
        sumArr[0] = Integer.parseInt(arr[0]);
        for (int i = 1; i < n; i++) {
            int curr = Integer.parseInt(arr[i]);
            sumArr[i] += sumArr[i - 1] + curr;
        }
        int left = 0;
        int right = 0;
        while (left <= right && right < n) {
            int diff;
            if (sumArr[right] == k) count++;
            diff = sumArr[right] - sumArr[left];
            if (diff == k) {
                count++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }

}