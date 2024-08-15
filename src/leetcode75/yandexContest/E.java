package leetcode75.yandexContest;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = reader.readLine().split(" ");
        int wordCount = Integer.parseInt(arr[0]);
        int queryCount = Integer.parseInt(arr[1]);
        int index = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        while (wordCount > 0) {
            wordCount--;
            String[] temp = reader.readLine().split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
            indexMap.put(Integer.parseInt(temp[1]), index++);
        }

        String query = "";
        HashMap<String, Integer> currMap = new HashMap<>();
        HashMap<String, Integer> tempMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        while (queryCount > 0) {
            queryCount--;
            String[] temp = reader.readLine().split(" ");
            if (Objects.equals(temp[0], "+")) {
                query += temp[1];
                int max = -1;
//                if (!currMap.isEmpty()) {
//                    for (String string : currMap.keySet()) {
//                        Integer priority = map.get(string);
//                        if (string.contains(query)) {
//                            tempMap.put(string, priority);
//                            max = Math.max(max, priority);
//                        }
//                    }
//                } else {
                    for (String string : map.keySet()) {
                        Integer priority = map.get(string);
                        if (string.contains(query)) {
                            tempMap.put(string, map.get(string));
                            max = Math.max(max, priority);
                        }
                    }

//                }
                res.add(indexMap.getOrDefault(max, -2) + 1);
                currMap = tempMap;
            } else if (Objects.equals(temp[0], "-")) {
                query = query.substring(0, query.length() - 1);
                int max = -1;

                for (String string : map.keySet()) {
                    Integer priority = map.get(string);
                    if (string.contains(query)) {
                        tempMap.put(string, map.get(string));
                        max = Math.max(max, priority);
                    }
                }
                res.add(indexMap.getOrDefault(max, -2) + 1);
                currMap = tempMap;
            }
        }
        writer.write(res.stream().map(Object::toString).collect(Collectors.joining("\n")));
        writer.close();
        reader.close();
    }
}
