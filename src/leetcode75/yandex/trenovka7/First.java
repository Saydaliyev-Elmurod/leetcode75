package leetcode75.yandex.trenovka7;

import java.io.*;

public class First {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sumBoy = 0;
        int sumGirl = 0;
        for (int i = 0; i < line.length; i++) {
            int temp = Integer.parseInt(line[i]);
            if (i % 2 == 0) {
                sumBoy += temp;
                min = Math.min(min, temp);
            } else {
                sumGirl += temp;
                max = Math.max(max, temp);
            }
        }
        System.out.println(min);
        System.out.println(max);
        System.out.println(sumBoy);
        System.out.println(sumGirl);
        int res;
        if (min > max) {
            res = sumBoy - sumGirl;
        } else {
            res = sumBoy - min + max - (sumGirl - max + min);
        }
        writer.write(String.valueOf(res));
        reader.close();
        writer.close();
    }
}
