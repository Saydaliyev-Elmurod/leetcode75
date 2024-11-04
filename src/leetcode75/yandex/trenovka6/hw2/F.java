package leetcode75.yandex.trenovka6.hw2;

import java.io.*;

public class F {
    // a1 a2 a3 a4
    // a1 a2 a3
    // a1 a2 a4
    // a1 a3 a4
    // a2 a3 a4

    // a2 a3
    // a2 a4
    // a3 a4
    // a3 a4

    public static void main(String[] args) throws IOException {
        // 1 3 5 6
        //
        BufferedReader reader = new BufferedReader(new FileReader("41.txt"));

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        long mod = 1_000_000_007;
        long[] a = new long[n];
        long[] sumArr = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(arr[i]);
        }
        long sum = 0;
        sumArr[0] = a[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + a[i];
        }
        for (int i = 1; i < n; i++) {
            sum = (sum + (((sumArr[i - 1] % mod) * ((sumArr[n - 1] - sumArr[i]) % mod)) % mod * a[i]) % mod) % mod;
        }
        writer.write(String.valueOf(sum));
        reader.close();
        writer.close();
    }
}