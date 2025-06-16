package leetcode75.yandex.uzbcup;

import java.io.*;

public class B {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int row = 0;
        int column = 0;
        String line = reader.readLine();
        if (line == null || line.isEmpty()) {
            writer.write(row + " " + column);
            writer.close();
            reader.close();
            return;
        }
        final String[] columnStr = line.split(" ");
        column = columnStr.length;

        while (line != null && !line.isEmpty()) {
            line = reader.readLine();
            row++;
        }
        writer.write(row + " " + column);
        writer.close();
        reader.close();
    }
}
