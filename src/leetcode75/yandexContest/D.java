package leetcode75.yandexContest;

import java.io.*;
import java.util.HashSet;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int position = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        HashSet<Integer> set = new HashSet<>();
        int n = line.length();
        int[] arr = new int[line.length() + 1];
        arr[0] = position;
        int direction = 1;
        for (int i = 0; i < line.length() ; i++) {
            char charAt = line.charAt(i);
            if (charAt == 'R') {
                direction = 1;
            } else if (charAt == 'L') {
                direction = -1;
            } else {
                position += direction;
            }
            arr[i] = position;
        }
        direction = 1;
        for (int i = 0; i < line.length() - 1; i++) {
            char item = line.charAt(i);
            if (item == 'R') {
                // case L
                set.add(direction * (arr[n-1] - arr[i]));
                // case F
                set.add(direction + (arr[n-1] - arr[i]));
                direction = 1;
            } else if (item == 'L') {
                // case R
                set.add((arr[n-1] - arr[i]));
                // case F
                set.add(direction + (arr[n-1] - arr[i]));
                direction = -1;

            } else {
                // case R
                set.add((arr[n-1] - arr[i] - direction));
                // case L
                set.add(direction + (arr[n-1] - arr[i]));
            }
        }
        writer.write(String.valueOf(set.size()));
        reader.close();
        writer.close();
    }

//    private static Integer findPosition(String line, Integer position) {
//        int a = 1;
//        for (int i = 0; i < line.length(); i++) {
//            char charAt = line.charAt(i);
//            if (charAt == 'R') {
//                a = 1;
//            } else if (charAt == 'L') {
//                a = -1;
//            } else {
//                position += a;
//            }
//        }
//        return position;
//    }
}
