package leetcode75.adventofcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] arr = line.split(" {3}");
            int right = Integer.parseInt(arr[1]);
            first.add(Integer.valueOf(arr[0]));
            second.add(right);
            map.put(right, map.getOrDefault(right, 0) + 1);
        }
        // first
        first.sort(Comparator.naturalOrder());
        second.sort(Comparator.naturalOrder());
        int size = first.size();
        int firstAnswer = 0;
        int secondAnswer = 0;

        for (int i = 0; i < size; i++) {
            firstAnswer += Math.abs(second.get(i) - first.get(i));
            secondAnswer += map.getOrDefault(first.get(i), 0) * first.get(i);
        }
        System.out.println("First answer " + firstAnswer);
        System.out.println("Second answer " + secondAnswer);


        // second part
        writer.close();
        reader.close();
    }
}
