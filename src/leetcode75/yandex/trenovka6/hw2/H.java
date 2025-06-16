package leetcode75.yandex.trenovka6.hw2;

import java.io.*;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        long[] a = new long[n];
        long[] revSumArr = new long[n];
        long[] sumArr = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(arr[i]);
        }
        sumArr[0] = a[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + a[i];
            revSumArr[n - 1 - i] = revSumArr[n - 1 - i - 1] + a[n - 1 - i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += sumArr[j];
            }
            for (int j = i + 1; j < n; j++) {
                sum += revSumArr[j];
            }
            min = Math.min(sum, min);
        }

//        writer.write(String.valueOf(sum));
        reader.close();
        writer.close();
    }
}