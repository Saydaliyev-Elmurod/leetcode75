package leetcode75.yandex.trenovka6.hw2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class First {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(arr[i]);
            list.add(sum);
        }
        String result = list.stream()
                .map(Object::toString) // Convert each Integer to String
                .collect(Collectors.joining(" "));

        writer.write(result);
        reader.close();
        writer.close();

    }

}