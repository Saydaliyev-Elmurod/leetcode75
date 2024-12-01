package leetcode75.yandexContest;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = reader.readLine().split(" ");
        int wordCount = Integer.parseInt(arr[0]);
        int queryCount = Integer.parseInt(arr[1]);
        int index = 0;
        HashMap<String, Integer> indexMap = new HashMap<>();
        List<Dictionary> queries = new ArrayList<>();
        while (wordCount > 0) {
            String[] temp = reader.readLine().split(" ");
            int priority = Integer.parseInt(temp[1]);
            indexMap.put(temp[0], ++index);
            queries.add(new Dictionary(priority, temp[0]));
            wordCount--;
        }
        StringBuilder prefix = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();
        HashMap<Integer, String> prefixMapIndex = new HashMap<>();
        index = 0;
        while (queryCount > 0) {
            String[] s = reader.readLine().split(" ");
            String operation = s[0];
            if (operation.equals("+")) {
                String p = s[1];
                prefix.append(p);
            } else {
                prefix = new StringBuilder(prefix.substring(0, prefix.length() - 1));
            }
            prefixMapIndex.put(index++, prefix.toString());
            set.add(prefix.toString());
            queryCount--;
        }
//        boolean isLastNotFound = false;
        HashMap<String, Integer> result = new HashMap<>();
        for (String item : set) {
//            if (isLastNotFound) {
//                result.put(item, -1);
//            } else {
            List<Dictionary> available = queries.stream().filter(i -> i.value.startsWith(item)).sorted((o1, o2) -> o2.priority.compareTo(o1.priority)).toList();
            if (available.isEmpty()) {
//                isLastNotFound = true;
                result.put(item, -1);
            } else {
                Integer i = indexMap.get(available.get(0).value);
                result.put(item, i);
            }
//            }
        }
        for (int i = 0; i < index; i++) {
            String p = prefixMapIndex.get(i);
            res.add(result.get(p));
        }

        String ans = res.stream().map(Object::toString).collect(Collectors.joining("\n"));
        writer.write(ans);
        writer.close();
        reader.close();
    }

    static class Dictionary {
        Integer priority;
        String value;

        public Dictionary(final int priority, final String value) {
            this.priority = priority;
            this.value = value;
        }
    }
}
