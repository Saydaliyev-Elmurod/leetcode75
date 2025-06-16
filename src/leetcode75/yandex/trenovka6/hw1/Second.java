package leetcode75.yandex.trenovka6.hw1;

import java.io.*;

public class Second {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(reader.readLine());//red
        int b = Integer.parseInt(reader.readLine());//blue
        int c = Integer.parseInt(reader.readLine());//red
        int d = Integer.parseInt(reader.readLine());//blue
        // 1 2 3 4
        int redMin = Math.min(a + 1, b + 1);
        int redMax = Math.max(a + 1, b + 1);
        int blueMin = Math.min(c + 1, d + 1);
        int blueMax = Math.max(c + 1, d + 1);
        if ((a <= b && c <= d) || (a >= b && c >= d)) {
            writer.write(redMin + " " + blueMin);
        } else {
            if (redMax + blueMin > redMin + blueMax) {
                writer.write(redMin + " " + blueMax);
            } else {
                writer.write(redMax + " " + blueMin);
            }
        }
        reader.close();
        writer.close();
    }
}
