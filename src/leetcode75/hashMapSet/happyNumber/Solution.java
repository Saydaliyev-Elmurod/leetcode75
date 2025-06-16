package leetcode75.hashMapSet.happyNumber;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            String number = n + "";
            int sum = 0;
            for (int i = 0; i < number.length(); i++) {
                sum += (int) Math.pow(Integer.parseInt(number.charAt(i) + ""), 2);
            }
            n = sum;
            if (n == 1) {
                return true;
            } else {
                if (!set.add(n)) {
                    return false;
                }
            }
        }
    }
}