package leetcode75.yandexContest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = reader.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);
        int index = 0;
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();
        while (n > 0) {
            String s = reader.readLine();
            list.add(s);
            dictionary.put(s, ++index);
            n--;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list1;
        List<Integer> res = new ArrayList<>();
        while (q > 0) {
            String[] s = reader.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            String p = s[1];
            list1 = map.get(p);
            if (list1 == null) {
                list1 = list.stream().filter(i -> i.startsWith(p)).toList();
                map.put(p, list1);
            }
            if (list1.size() >=k) {
                String item = list1.get(k - 1);
                res.add(dictionary.get(item));
            } else {
                res.add(-1);
            }
            q--;
        }
        String ans = res.stream().map(Object::toString).collect(Collectors.joining("\n"));
        writer.write(ans);
        writer.close();
        reader.close();
    }
}
