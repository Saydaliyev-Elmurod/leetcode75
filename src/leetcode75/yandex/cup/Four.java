package leetcode75.yandex.cup;

import java.io.*;

public class Four {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        long max = 100L;
        long min = 1;
        int count = 0;
        label:
        while (count < 200) {
            count++;
            long temp = (max + min) / 2;
            writer.write(String.valueOf(temp));
            writer.newLine();
            writer.flush();
            line = reader.readLine();
            switch (line) {
                case "wet":
                    min = temp + 1;
                    max = min * 2;
                    break;
                case "ok":
                    max = temp;
                    if (max == min) {
                        writer.write(String.format("! %s\n", max));
                        break label;
                    }
                    break;
                case "fail":
                    max = max / 2;
                    break;
            }
        }
        writer.write(String.format("! %s\n", max));
        reader.close();
        writer.close();
    }


}
