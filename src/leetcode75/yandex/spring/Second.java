package leetcode75.yandex.spring;

import java.io.*;

public class Second {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int[] qArr = new int[n];
        int[] cArr = new int[n];
        String qLine = reader.readLine();
        final String[] qLineArr = qLine.split(" ");
        int index = 0;
        for (String str : qLineArr) {
            qArr[index++] = Integer.parseInt(str);
        }

        String cLine = reader.readLine();
        final String[] cArrStr = cLine.split(" ");
        index = 0;
        for (String str : cArrStr) {
            cArr[index++] = Integer.parseInt(str);
        }

        final String[] string = reader.readLine().split(" ");
        int a = Integer.parseInt(string[0]);
        int b = Integer.parseInt(string[1]);

        double sum = 0;
        if (a < b) {
            for (int i = 0; i < n; i++) {
                double di = a + (double) cArr[i] * (b - a) / 255;
                sum += qArr[i] * di;
            }
        } else {
            for (int i = 0; i < n; i++) {
                sum += qArr[i] * a;
            }
        }

        writer.write(String.valueOf((long) sum));
        writer.close();
        reader.close();
    }
}
