package leetcode75.yandex.trenovka7;

import java.io.*;
import java.util.Objects;

public class Seven {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[][] arr = new String[n][m];
        int index = 0;
        while (index < n) {
            String[] str = reader.readLine().split("");
            arr[index] = str;
            index++;
        }

        // X
        boolean found = false;
        found = checkHorizontal(arr, found, n, m, "O");
        found = checkHorizontal(arr, found, n, m, "X");
        found = checkVertical(arr, found, n, m, "O");
        found = checkVertical(arr, found, n, m, "X");
        for (int i = 2; i < n - 2 && !found; i++) {
            for (int j = 2; j < m - 2; j++) {
                if (!arr[i][j].equals(".") && Objects.equals(arr[i + 1][j - 1], arr[i][j])
                        && arr[i + 2][j - 2].equals(arr[i][j])
                        && arr[i - 1][j + 1].equals(arr[i][j])
                        && arr[i - 2][j + 2].equals(arr[i][j])) {
                    found = true;
                    break;
                }
                if (!arr[i][j].equals(".") && Objects.equals(arr[i - 1][j - 1], arr[i][j])
                        && arr[i - 2][j - 2].equals(arr[i][j])
                        && arr[i + 1][j + 1].equals(arr[i][j])
                        && arr[i + 2][j + 2].equals(arr[i][j])) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            writer.write("Yes");
        } else {
            writer.write("No");
        }
        reader.close();
        writer.close();
    }

    private static boolean checkHorizontal(String[][] arr, boolean found, int n, int m, String check) {
        for (int i = 0; i < n && !found; i++) {
            int sum = 0;
            for (int j = 0; j < m && !found; j++) {
                if (!arr[i][j].equals(check)) {
                    sum = 0;
                } else {
                    sum++;
                }
                if (sum >= 5) {
                    found = true;
                }
            }
        }
        return found;
    }

    private static boolean checkVertical(String[][] arr, boolean found, int n, int m, String check) {
        for (int i = 0; i < m && !found; i++) {
            int sum = 0;
            for (int j = 0; j < n && !found; j++) {
                if (!arr[j][i].equals(check)) {
                    sum = 0;
                } else {
                    sum++;
                }
                if (sum >= 5) {
                    found = true;
                }
            }
        }
        return found;
    }
}
