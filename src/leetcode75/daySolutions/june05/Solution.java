package leetcode75.daySolutions.june05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    //https://leetcode.com/problems/find-common-characters/
    public List<String> commonChars(String[] words) {
        if (words.length == 1) {
            return getList(words[0]);
        }
        int[] a = count(words[0]);
        int[] b = count(words[1]);
        join(a, b);
        for (int i = 2; i < words.length; i++) {
            join(a, count(words[i]));
        }
        return getResult(a);
    }

    private List<String> getResult(final int[] a) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                for (int j = 0; j < a[i]; j++) {
                    res.add(String.valueOf((char)(i + 'a')));
                }
            }
        }
        return res;
    }

    private List<String> getList(final String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            res.add(String.valueOf(word.charAt(i)));
        }
        return res;
    }

    private void join(final int[] a, final int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0 && b[i] != 0) {
                a[i] = Math.min(a[i], b[i]);
            } else {
                a[i] = 0;
                b[i] = 0;
            }
        }
    }

    private int[] count(final String word) {
        int[] a = new int[26];
        for (char c : word.toCharArray()) {
            a[c - 'a']++;
        }
        return a;
    }
}