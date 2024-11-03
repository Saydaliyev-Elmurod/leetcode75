package leetcode75.yandex.trenovka6.hw1;

import java.io.*;

public class First {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int x1 = Integer.parseInt(reader.readLine());
        int y1 = Integer.parseInt(reader.readLine());
        int x2 = Integer.parseInt(reader.readLine());
        int y2 = Integer.parseInt(reader.readLine());
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        String res = "";
        if (x1 < x && x < x2) {
            if (y > y2) res = "N";
            else res = "S";
        } else if (y1 < y && y < y2) {
            if (x1 > x) res = "W";
            else res = "E";
        } else if (y > y2) {
            res = "N";
            if (x < x1) res += "W";
            else res += "E";
        } else if (y < y1) {
            res = "S";
            if (x < x1) res += "W";
            else res += "E";
        }
        writer.write(res);
        reader.close();
        writer.close();
    }
}
