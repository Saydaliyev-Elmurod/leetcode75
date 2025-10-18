package leetcode75.yandex.trenovka7;

import java.io.*;

public class Six {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[][] arr = new String[n][m];
        int index = 0;
        while (index < n) {
            String[] str = reader.readLine().split("");
            arr[index] = str;
            index++;
        }
        int[] max = new int[n];
        int[] min = new int[m];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("-")) {
                    sum--;
                } else {
                    sum++;
                }
            }
            max[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j][i].equals("+")) {
                    sum++;
                } else {
                    sum--;
                }
            }
            min[i] = sum;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("?")) {
                    res = Math.max(res, max[i] - min[j] - 2);
                } else {
                    res = Math.max(res, max[i] - min[j]);
                }
            }
        }
        writer.write(String.valueOf(res));
        reader.close();
        writer.close();
    }
}
