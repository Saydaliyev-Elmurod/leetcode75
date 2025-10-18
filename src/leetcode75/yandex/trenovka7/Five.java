package leetcode75.yandex.trenovka7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Five {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = reader.readLine().split(" ");
        long n = Long.parseLong(arr[0]);
        int k = Integer.parseInt(arr[1]);
        if (n % 10 == 5 || n % 10 == 0) {
            writer.write((n + n % 10) + "\n");
        } else {
            while (n % 10 != 2 && k-- > 0) {
                n += n % 10;
            }
            n += (long) 20 * (k / 4);
            if (k % 4 == 1) {
                n += 2;
            } else if (k % 4 == 2) {
                n += 6;
            } else if (k % 4 == 3) {
                n += 14;
            }
            writer.write(n + " ");
        }
        reader.close();
        writer.close();
    }
}
