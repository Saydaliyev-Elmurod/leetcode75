package leetcode75.yandexContest.revocup;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
    public static void main(String[] args)  throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> revoCup = new HashSet<>();
        HashSet<String> kep = new HashSet<>();
        int a = Integer.parseInt(reader.readLine());
        while (a-- > 0) {
            String str = reader.readLine();
            revoCup.add(str);
        }

        a = Integer.parseInt(reader.readLine());
        while (a-- > 0) {
            String str = reader.readLine();
            kep.add(str);
        }
        revoCup.forEach(
                revo -> {
                    if (!kep.contains(revo)) {
                        System.out.println(revo);
                    }
                }
        );
    }
}
