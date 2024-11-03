package leetcode75.yandex.cup;

import java.io.*;

public class Threee {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = reader.readLine();
        String[] arr = line.split("");
        int coordinate1 = 0;
        int coordinate2 = 0;
        int max1 = 0;
        int max2 = 0;
        int min1 = 0;
        int min2 = 0;
        for (String s : arr) {
            switch (s) {
                case "R" -> {
                    coordinate1++;
                    coordinate2++;
                    max1 = Math.max(coordinate1, max1);
                    max2 = Math.max(coordinate2, max2);
                }
                case "L" -> {
                    coordinate1--;
                    coordinate2--;
                    min1 = Math.min(coordinate1, min1);
                    min2 = Math.min(coordinate2, min2);
                }
                case "?" -> {
                    coordinate1--;  // L
                    coordinate2++;  // R
                    min1 = Math.min(coordinate1, min1);
                    max2 = Math.max(coordinate2, max2);
                }
            }
        }
        writer.write(String.valueOf(Math.max(max2 - min2, max1 - min1)));
        reader.close();
        writer.close();
    }


}
