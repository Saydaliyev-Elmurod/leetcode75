package leetcode75.yandexContest.january;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class A {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] rowColumn = reader.readLine().split(" ");
        int r = Integer.parseInt(rowColumn[0]);
        int c = Integer.parseInt(rowColumn[1]);
        int temp = r;
        List<String> words = new ArrayList<>();
        char[][] arr = new char[r][c];
        while (temp > 0) {
            arr[r - temp] = reader.readLine().toCharArray();
            temp--;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != '#') {
                    str.append(arr[i][j]);
                } else {
                    if (str.length() >= 2) {
                        words.add(str.toString());
                    }
                    str = new StringBuilder();
                }

            }
            if (str.length() >= 2) {
                words.add(str.toString());
            }
            str = new StringBuilder();
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (arr[j][i] != '#') {
                    str.append(arr[j][i]);
                } else {
                    if (str.length() >= 2) {
                        words.add(str.toString());
                    }
                    str = new StringBuilder();
                }
            }
            if (str.length() >= 2) {
                words.add(str.toString());
            }
            str = new StringBuilder();
        }
        Optional<String> first = words.stream().min(String::compareTo);
        writer.write(first.orElse(""));
        writer.close();
        reader.close();
    }
}
