package leetcode75.yandex.trenovka7;

import java.io.*;

public class Second {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int v0 = Integer.parseInt(line[3]);
        int v1 = Integer.parseInt(line[4]);
        int v2 = Integer.parseInt(line[5]);
        double t1 = (double) a / v0 + (double) c / v1 + (double) b / v2;
        double t2 = (double) b / v0 + (double) c / v1 + (double) a / v2;
        double t3 = (double) a / v0 + (double) a / v1 + (double) b / v0 + (double) b / v1;
        double t4 = (double) a / v0 + (double) c / v1 + (double) (c + a) / v2;
        double t5 = (double) b / v0 + (double) c / v1 + (double) (c + b) / v2;
        double t6 = (double) (a + c) / v0 + (double) c / v1 + (double) (a) / v2;
        double t7 = (double) (b + c) / v0 + (double) c / v1 + (double) (b) / v2;
        double t8 = (double) (2 * a + c) / v0 + (double) (2 * a + c) / v1;
        double t9 = (double) (2 * b + c) / v0 + (double) (2 * b + c) / v1;
        double min = Math.min(t1, Math.min(t2, Math.min(t3, Math.min(t4, Math.min(t5, Math.min(t6, Math.min(t7, Math.min(t8, t9))))))));
        writer.write(String.valueOf(min));
        reader.close();
        writer.close();
    }
}
