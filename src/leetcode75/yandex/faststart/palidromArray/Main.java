package leetcode75.yandex.faststart.palidromArray;

import java.io.*;

public class Main {

    /*

     */
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(reader.readLine());
        String[] string = reader.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(string[i]);
        }
        int start = 0;
        while (!palidrom(start, arr)) {
            start++;
        }
        writer.write(String.valueOf(start)+"\n");
//        writer.newLine();
        if (start != 0) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < start; i++) {
                s.append(arr[start-i-1]).append(" ");
            }
            writer.write(s.toString().trim());
        }
        reader.close();
        writer.close();
    }

    public static boolean palidrom(int i, int[] arr) {
        int index = 0;
        for (int j = i; j <= (arr.length - 1 + i) / 2; j++) {
            if (arr[j] != arr[arr.length - 1 - index]) {
                return false;
            }
            index++;
        }
        return true;
    }

}
