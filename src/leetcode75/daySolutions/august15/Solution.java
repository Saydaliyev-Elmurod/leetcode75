package leetcode75.daySolutions.august15;

import java.util.HashMap;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            map.put(bill, map.getOrDefault(bill, 0) + 1);
            if (bill == 10) {
                Integer five = map.getOrDefault(5,0);
                if (five < 1) {
                    return false;
                }
                map.put(5, five - 1);
            } else if (bill == 20) {
                Integer ten = map.getOrDefault(10,0);
                Integer five = map.getOrDefault(5,0);
                if (ten < 1 && five < 3) {
                    return false;
                } else if (ten > 0 && five < 1) {
                    return false;
                } else if (ten > 0) {
                    map.put(10, ten - 1);
                    map.put(5, five - 1);
                } else {
                    map.put(5, five - 3);
                }
            }
        }
        return true;
    }
}