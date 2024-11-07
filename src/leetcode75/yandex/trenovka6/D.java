package leetcode75.yandex.trenovka6;

import java.io.*;
import java.util.Arrays;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] a = new int[n];

        String[] arr = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        // Сортируем массив
        Arrays.sort(a);

        int days = 0;
        int i = 0;

        while (i < n) {
            days++;
            int j = i;

            // Идем по массиву, пока разница не превышает k
            while (j < n && a[j] - a[i] <= k) {
                j++;
            }

            // Переходим к следующему уникальному делу
            i = j;
        }

        writer.write(String.valueOf(days));
        writer.close();
        reader.close();
    }
}
