package leetcode75.yandex.faststart.countword;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class Main {

    /*

     */
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        String line;
        Math.abs(-1);
        while ((line = reader.readLine()) != null) {
            char[] charArray = line.toCharArray();
            for (char c : charArray) {
                if (c == ' '||c=='\n'||c=='\'') {
                    set.add(s.toString());
                    s = new StringBuilder();
                } else {
                    s.append(c);
                }
            }
        }
        writer.write(String.valueOf(set.size()));
        reader.close();
        writer.close();
    }

}
