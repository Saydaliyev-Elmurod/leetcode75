package leetcode75.yandex.uzbcup;

import java.io.*;

public class G {
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] lineArr = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(lineArr[i]);
        }
        int[] sum = new int[n + 2];
        for (int i = 0; i < n; i++) {
            sum[i + 2] = arr[i] + sum[i];
            System.out.println(i + "->" + sum[i + 2]);
        }
        for (int i = 2; i < n + 2; i++) {
            for (int j = i + 1; j < n + 2; j++) {
                if ((i + j) % 2 == 0) {
                    if ((sum[j] - sum[i - 2]) == (sum[j - 1] - sum[i - 1])) {
//                System.out.println(left + " -" + right);
                        counter++;
                    }
                } else {
                    if ((sum[j] - sum[i - 1]) == (sum[j - 1] - sum[i - 2])) {
//                System.out.println(left + " -" + right);
                        counter++;
                    }
                }
            }
        }
        writer.write(counter + "");
        writer.close();
        reader.close();
    }


}
