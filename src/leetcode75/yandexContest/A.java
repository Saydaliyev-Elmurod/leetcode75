package leetcode75.yandexContest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder line = new StringBuilder(reader.readLine());
        List<String> arr = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int max = 0;
        for (int i = 0; i < line.length(); i++) {
            char item = line.charAt(i);
            if (item == ',') {
                if (!temp.isEmpty()) {
                    arr.add(temp.toString());
                    max = Math.max(temp.length(), max);
                    temp = new StringBuilder();
                }
                arr.add(",");
            } else if (Character.isLetter(item)) {
                temp.append(item);
            } else {
                if (!temp.isEmpty()) {
                    arr.add(temp.toString());
                    max = Math.max(temp.length(), max);
                    temp = new StringBuilder();
                }
            }
        }
        if (!temp.isEmpty()) {
            arr.add(temp.toString());
            max = Math.max(temp.length(), max);
        }
        int len = max * 3;
        StringBuilder res = new StringBuilder();
        line = new StringBuilder();
        for (String item : arr) {
            if (line.isEmpty()) {
                line.append(item);
            } else if (item.equals(",")) {
                if (line.length() < len) {
                    line.append(item);
                } else {
                    res.append("\n").append(line);
                    line = new StringBuilder();
                    line.append(item);
                }
            } else {
                if (item.length() + line.length() < len) {
                    line.append(" ").append(item);
                } else {
                    res.append("\n").append(line);
                    line = new StringBuilder();
                    line.append(item);
                }
            }
        }
        if (!line.isEmpty()) {
            res.append("\n").append(line);
        }
        if (res.toString().startsWith("\n")) {
            res.replace(0, 1, "");
        }

        writer.write(res.toString().trim());
        writer.close();
        reader.close();
    }
}
