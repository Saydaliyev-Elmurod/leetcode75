package leetcode75.yandex.uzbcup;

import java.io.*;

public class H {
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] lineArr = reader.readLine().split(" ");
        int l = Integer.parseInt(lineArr[0]);
        int r = Integer.parseInt(lineArr[1]);

        writer.close();
        reader.close();
    }


}
