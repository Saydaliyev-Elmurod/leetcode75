package leetcode75.yandexContest.january;

import java.io.*;

public class C {
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(reader.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int sumA = 0;
        int sumB = 0;
        int sumC = 0;
        String[] a = reader.readLine().split(" ");
        String[] b = reader.readLine().split(" ");
        String[] c = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(a[i]);
            B[i] = Integer.parseInt(b[i]);
            C[i] = Integer.parseInt(c[i]);
            sumA += A[i];
            sumB += B[i];
            sumC += C[i];
        }

        for (int i = 0; i < n; i++) {

        }
        writer.close();
        reader.close();
    }


}
