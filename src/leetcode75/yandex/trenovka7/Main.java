package leetcode75.yandex.trenovka7;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int p = a + b + c;
        int s= p*(p-(a+c))*(p-(a+b))*(p-(b+c));
        System.out.println(s+" "+s);
        sc.close();
    }
}
