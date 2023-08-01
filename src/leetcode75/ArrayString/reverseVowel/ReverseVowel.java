package leetcode75.ArrayString.reverseVowel;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowel {
    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        List<Character> list = new ArrayList<Character>();
        String vowels = "aeiouAEUIO";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (vowels.indexOf(String.valueOf(a))!=-1) {
                list.add(a);
            }
        }
        int n = list.size() - 1;
        String r = new String();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (vowels.indexOf(String.valueOf(a))==-1) {
                r += a;
            } else {
                r += list.get(n);
                n--;
            }
        }
        return r;
    }


}
