package leetcode75.yandex.winter;

import java.io.*;
import java.util.Arrays;

public class Second {
//https://coderun.yandex.ru/selections/winter-intern-24/problems/lap?currentPage=1&pageSize=20&search=

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int time = Integer.parseInt(str[1]);
        int s = Integer.parseInt(str[2]);
        String[] speed = reader.readLine().split(" ");
        double firstCount = Double.parseDouble(speed[0]) * time / s;
        double sum = 0;
        for (int i = 1; i < n; i++) {
            double count = (double) (Integer.parseInt(speed[i]) * time) / s;
            if (firstCount > count) {
                sum += firstCount - count ;
            }
        }
        writer.write(String.valueOf((int) sum));
        reader.close();
        writer.close();
    }

}
