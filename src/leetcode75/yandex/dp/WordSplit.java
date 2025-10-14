//package leetcode75.yandex.dp;
//
//import java.io.*;
//import java.util.*;
//
//public class G {
//    static int count2 = 0;
//    static int[][] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(reader.readLine());
//        //    int[] dp = new int[n + 1];
//        //    dp[1] = 1;  dp[n][m] n - boshlangich qiymat m - eng oxirgi step
//        // dp[3][2] 3 ta tanga bor undan oldin oxirgi marta 2 ishlatilgan
//        dp = new int[n + 1][n + 1];
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            int canCreate = isCanCreate(n - i, i);
//            isCanCreater(n - i, i);
//            sum += canCreate;
//        }
//        // n = 10  9,1 8,2 7,3 6,4 5,5 4,6 3,7 2,8 1,9 0,10
//        // 3 30 21
//        // 4 40 31
//        // 5 50 41 32
//        // 6 60 51 42 321
//        // 7 70 61 52 43 421
//        writer.write(String.valueOf(count2 + "\n"));
//        writer.write(String.valueOf(sum));
//        reader.close();
//        writer.close();
//    }
//
//    // 40
//    // 1113
//    //    23
//    // 104
//    //    13
//    // 18
//    private static int isCanCreate(int cube, int prev) {
//        int res = 0;
//        if (cube > 0 && dp[prev][cube] != 0) {
//            return dp[prev][cube];
//        }
//        if (cube == 0) {
//            res++;
//        }
//        for (int i = 1; i < prev && cube > 0; i++) {
//            res += isCanCreate(cube - i, i);
//        }
//        if (cube > 0) {
//            dp[prev][cube] = res;
//        }
//        return res;
//    }
//
//    private static void isCanCreater(int cube, int prev) {
//        if (cube == 0) {
//            count2++;
//        }
//        for (int i = 1; i < prev && cube > 0; i++) {
//            isCanCreater(cube - i, i);
//        }
//    }
//}
