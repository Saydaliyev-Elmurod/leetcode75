package leetcode75.yandex.trenovka6.hw2;
import java.io.*;
import java.util.Arrays;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] arr = reader.readLine().split(" ");
        int[] a = new int[n];
        int right = 1;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(a);
        int count = 0;
        int last = a[0];
        a[0] = 0;
        while (right < n) {
            if (a[right] != 0) {
                int diff = a[right] - last;
                if (diff > k) {
                    last = a[right];
                    a[right] = 0;
                }
            }
            right++;
            if (right == n) {
                int item = findLeft(a);
                if (item == 0) break;
                else {
                    last = a[item];
                    count++;
                    right = item + 1;
                    a[item] = 0;
                }
            }
        }

        writer.write(String.valueOf(count + 1));
        reader.close();
        writer.close();
    }

    private static int findLeft(final int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) return i;
        }
        return 0;
    }

}