package leetcode75.yandex.algo;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class First {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str= reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Integer[][] arr = new Integer[m][2];
        int index = 0;
        while (m-- > 0) {
            String line = reader.readLine();
            String[] split = line.split(" ");
            arr[index][0] = Integer.parseInt(split[0]);
            arr[index][1] = Integer.parseInt(split[1]);
            index++;
        }
        // 1->5 2->6 4-7 9-10

        Arrays.sort(arr, (a, b) -> (int) a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int currentEnd = arr[0][1];
        int currentStart = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] > currentEnd) {
                n = n - (currentEnd - currentStart+1);
                currentStart = arr[i][0];
            }
            currentEnd = Math.max(currentEnd, arr[i][1]);
        }
        System.out.println(n-(currentEnd-currentStart+1));
    }
}
