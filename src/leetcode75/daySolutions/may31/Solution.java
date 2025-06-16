package leetcode75.daySolutions.may31;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(i -> {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        });
        List<Integer> list = set.stream().toList();
        return new int[]{list.get(0), list.get(1)};
    }
}