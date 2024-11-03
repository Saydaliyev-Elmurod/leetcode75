package leetcode75.yandex.trenovka6.hw2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class E {

    public static void main(String[] args) throws IOException {
        //5 17
        //10 7 10 7 10 17 10 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(a);
        int left;
        int right;
        boolean isLeft = n % 2 == 0;
        // 1 2 3 4 5   1 2 3 4  1 2 2 4
        // 1 2 0 4 5   1 0 3 4  1 0 2 4
        // 1 0 0 4 5   1 0 0 4  1 0 0 4
        // 1 0 0 0 5   0 0 0 4  0 0 0 4
        // 0 0 0 0 5   0 0 0 0
        List<Integer> list = new ArrayList<>();
        if (n == 1) list.add(a[0]);
        else {
            if (n % 2 == 0) {
                left = n / 2 - 1;
                right = n / 2 - 1;
            } else {
                left = n / 2;
                right = n / 2;
            }
            list.add(a[(left + right) / 2]);
            right++;
            left--;
            while (left > -1 || right < n) {
                if (isLeft) {
                    list.add(a[right]);
                    right++;
                    isLeft = false;
                } else {
                    list.add(a[left]);
                    left--;
                    isLeft = true;
                }
            }
        }
        String line = list.stream().
                map(Objects::toString).collect(Collectors.joining(" "));
        writer.write(line);
        reader.close();
        writer.close();
    }


}