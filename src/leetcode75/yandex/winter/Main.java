package leetcode75.yandex.winter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ab = a + b;
        int bc = b + c;
        int ca = c + a;

        if (ab + bc <= ca || ab + ca <= bc || bc + ca <= ab) {
            System.out.println(-1);
            return;
        }

        int p = a + b + c;
        long S2 = (long)p * (p - ab) * (p - bc) * (p - ca);
        System.out.println(S2 + " " + S2);
    }
}
