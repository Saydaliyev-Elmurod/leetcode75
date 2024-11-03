package leetcode75.yandex.trenovka6.hw2;

import java.io.*;

public class Three {

    public static void main(String[] args) throws IOException {
        //5 17
        //10 7 10 7 10 17 10 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] string = reader.readLine().split(" ");
        int n = Integer.parseInt(string[0]);
        int r = Integer.parseInt(string[1]);
        long count = 0;
        int right = 1;
        int left = 0;
        String[] arr = reader.readLine().split(" ");
        while (left < right && right < n) {
            if (Integer.parseInt(arr[right]) - Integer.parseInt(arr[left]) > r) {
                count += n - right;
                left++;
            } else {
                right++;
            }
            if (left == right) right++;
        }
        writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }

}