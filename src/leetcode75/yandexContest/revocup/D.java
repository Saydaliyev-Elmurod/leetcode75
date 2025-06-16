package leetcode75.yandexContest.revocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String domain = reader.readLine();
        String fake = reader.readLine();
        if (fake.equals(domain) || (fake.length() < domain.length())) {
            System.out.println("No");
            return;
        }
        if (fake.startsWith(domain)) {
            System.out.println("Yes");
            return;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('O', '0');
        map.put('o', '0');
        map.put('l', '1');
        map.put('I', '1');
        map.put('S', '5');
        map.put('E', '3');
        for (int i = 0; i < domain.length(); i++) {
            char d = domain.charAt(i);
            char f = fake.charAt(i);
            if (!(d == f || (map.get(d) != null && map.get(d) == f))) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        reader.close();
    }

}

