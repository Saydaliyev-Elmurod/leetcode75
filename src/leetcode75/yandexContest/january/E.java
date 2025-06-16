package leetcode75.yandexContest.january;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class E {

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        List<String> queries = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(reader.readLine());
        while (q-- > 0) {
            String word = reader.readLine();
            words.add(word);
        }
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String word = reader.readLine();
            queries.add(word);
        }
        List<Integer> res = new ArrayList<>();
        for (String query : queries) {
            if (map.containsKey(query)) {
                res.add(map.get(query));
            } else {
                int count = 0;
                int max = 0;
                for (String word : words) {
                    count++;
                    if (query.equals(word)) {
                        max += query.length();
                        break;
                    } else if (query.startsWith(word) || word.startsWith(query)) {
                        max += Math.min(query.length(), word.length());
                    } else {
                        max += findPrefixCount(query, word);
                    }
                }
                map.put(query, count + max);
                res.add(count + max);
            }

        }
        writer.write(res.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n")));
        writer.close();
        reader.close();
    }

    private static int findPrefixCount(String query, String word) {
        int count = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == word.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;

    }


}
