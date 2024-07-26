package leetcode75.yandex.faststart.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    /*
	https://coderun.yandex.ru/selections/quickstart/problems/open-calculator?currentPage=1&pageSize=20
	*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = reader.readLine().split(" ");
        char[] n = reader.readLine().toCharArray();
        int size;
        Set<String> a = new HashSet<>();
        for (char c : n) {
            a.add(c + "");
        }
        size = a.size();
        Collections.addAll(a, arr);
        writer.write(a.size() - size);
        reader.close();
        writer.close();
    }
}
