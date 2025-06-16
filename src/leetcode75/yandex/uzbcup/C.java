package leetcode75.yandex.uzbcup;

import java.io.*;

public class C {
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        final String[] lines = reader.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[1]);
        int s = Integer.parseInt(lines[2]);
        for (int i = 0; i <= b - 1; i++) {
            calculate(b, n, s, i, i + "");
        }
        writer.write(counter + "");
        writer.close();
        reader.close();
    }

    private static void calculate(final int b, final int n, final int s, final int sumDigit, final String curr) {
        if (sumDigit > s) {
            return;
        }
        if (curr.length() == n) {
            System.out.println(curr);
            if (sumDigit == s) {
                System.out.println("Find " + curr);
                counter++;
            }
            return;
        }
        for (int i = 0; i <= b - 1; i++) {
            calculate(b, n, s, sumDigit + i, curr + i);
        }
    }
}
