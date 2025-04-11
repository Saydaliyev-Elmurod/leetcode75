package leetcode75.yandexContest.revocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        // 12 123 1234 12345 123456 123456789
        if (num < 12) {
            System.out.println(-1);
            return;
        } else {
//            num = mod2(num, 12);
        }
        System.out.println(num);
        reader.close();
    }




}

