package leetcode75.daySolutions.august06;

import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        // 2- 9 =8
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            Character ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        int index = 2;
        int degree = 1;
        int sum = 0;
        for (Integer integer : list) {
            sum += integer * degree;
            if (index % 9 == 0) {
                index = 2;
                degree++;
            } else {
                index++;
            }
        }

        return sum;
    }
}