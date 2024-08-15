package leetcode75.yandexContest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class First {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();
        List<String> arr = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        int max = 0;
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (charAt == ',') {
                if (!curr.isEmpty()) {
                    arr.add(curr.toString());
                    max = Math.max(curr.length(), max);
                    curr = new StringBuilder();
                }
                arr.add(",");
            } else if (Character.isLetter(charAt)) {
                curr.append(charAt);
            } else {
                if (!curr.isEmpty()) {
                    arr.add(curr.toString());
                    max = Math.max(curr.length(), max);
                    curr = new StringBuilder();
                }
            }
        }
        if (!curr.isEmpty()) {
            arr.add(curr.toString());

            max = Math.max(curr.length(), max);
        }
        int len = max * 3;
        StringBuilder res = new StringBuilder();
        int currentLength = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (currentLength + arr.get(i).length() <= len) {
                if (Objects.equals(arr.get(i), ",")) {
                    res.append(",");
                    currentLength++;
                    if (!checkIsLast(arr, i, currentLength, len)) {
                        res.append(" ");
                        currentLength++;
                    }
                } else {
                    String item = arr.get(i);
                    res.append(item);
                    if (!checkIsLast(arr, i, currentLength, len) && i + 1 < arr.size() && !arr.get(i + 1).equals(",")) {
                        res.append(" ");
                        currentLength++;
                    }
                    currentLength += item.length();
                }
            } else {
                currentLength = 0;
                res.append("\n");
                i--;
            }
        }
        writer.write(res.toString());
    }

    private static boolean checkIsLast(final List<String> arr, final int i, final int currentLength, final int len) {
        if (arr.size() - 1 > i) {
            return !(arr.get(i + 1).length() + currentLength <= len);
        }
        return true;
    }

}
