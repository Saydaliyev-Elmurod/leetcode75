package leetcode75.daySolutions.june04;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        boolean isOdd = false;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 0) {
                count += e.getValue();
            }  else {
                isOdd = true;
                count += e.getValue() - 1;
            }
        }
        return count + (isOdd ? 1 : 0);
    }
}