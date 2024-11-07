package leetcode75.yandex.trenovka6.hw2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        // 1 2 3 4 5 6 7 8 9
        // 0 2 3 0 5 6 0 8 9
        // 0 0 3 0 0 6 0 0 9
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] arr = reader.readLine().split(" ");
        Integer[] a = new Integer[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(a));
        list.sort(Integer::compareTo);
        int size = list.size() - 1;
        int count = 0;
        int last = list.get(0);
        list.remove(0);
        while (right < size) {
            int temp = list.get(right);
            if (temp != 0) {
                int diff = temp - last;
                if (diff > k) {
                    last = temp;
                    list.remove(right);
                    size--;
                    right--;
                }
            }
            right++;
            if (right == list.size()) {
                if (size == 0) break;
                else {
                    last = list.get(0);
                    count++;
                    right = 0;
                    list.remove(0);
                    size--;
                }
            }
        }

        writer.write(String.valueOf(count + 1));
        reader.close();
        writer.close();
    }
}