package leetcode75.yandex.uzbcup;

import java.io.*;

public class First {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        final int num = Integer.parseInt(reader.readLine());
        if (num == 0 || num == 1) {
            writer.write("1");
            return;
        }
        writer.write("0");
        writer.close();
        reader.close();
    }
}
