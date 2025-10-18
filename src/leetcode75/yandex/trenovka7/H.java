package leetcode75.yandex.trenovka7;

import java.io.*;

public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
//        boolean[] dp = new boolean[n + 1];
//        for (int i = 1; i <= 3 && i <= n; i++) {
//            dp[i] = true;
//        }
//        for (int i = 5; i <= n; i++) {
//            //case 1
//            boolean n1 = isNotPrime(i - 1) && !dp[i - 1];
//            if (n1) {
//                dp[i] = true;
//                continue;
//            }
//            boolean n2 = isNotPrime(i - 2) && !dp[i - 2];
//            if (n2) {
//                dp[i] = true;
//                continue;
//            }
//            boolean n3 = isNotPrime(i - 3) && !dp[i - 3];
//            if (n3) {
//                dp[i] = true;
//            }
//        }
//        writer.write(String.valueOf(dp[n] ? 1 : 2));
        writer.write(String.valueOf(n % 4 == 0 ? 2 : 1));
        reader.close();
        writer.close();
    }

    public static boolean isNotPrime(int n) {
        if (n <= 1) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
