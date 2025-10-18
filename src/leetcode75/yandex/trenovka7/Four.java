package leetcode75.yandex.trenovka7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Four {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] str = reader.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(str[i]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (entry.getValue() > 0) {
                    map.put(key, entry.getValue() - 1);
                    res.append(" ").append(entry.getKey());
                    k--;
                    if (k <= 0) {
                        break;
                    }
                }

            }
        }
        writer.write(res.substring(1));
        reader.close();
        writer.close();
    }
}
