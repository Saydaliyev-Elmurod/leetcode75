package leetcode75.yandex.faststart.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    /*
	https://coderun.yandex.ru/selections/quickstart/problems/list-growing?currentPage=1&pageSize=20
	*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int prev = Integer.MIN_VALUE;
        String[] split = reader.readLine().split(" ");
        for (String num : split) {
            int number = Integer.parseInt(num);
            if (number < prev) {
                writer.write("NO");
                reader.close();
                writer.close();
                return;
            } else {
                prev = number;
            }
        }
        writer.write("YES");
        reader.close();
        writer.close();
    }

}
