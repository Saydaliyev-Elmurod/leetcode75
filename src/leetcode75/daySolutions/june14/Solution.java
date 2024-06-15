package leetcode75.daySolutions.june14;

import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int movement = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                list.add(num);
            }
        }

        List<Integer> sortedList
                = list.stream().sorted().toList();
        int max = 0;
        for (Integer i : sortedList) {
            movement+= Math.max(max - i, 0);
            i=Math.max(max,i);
            while (set.contains(i)) {
                i++;
                movement++;
            }
            set.add(i);
            max = i;
        }
        return movement;
    }
}