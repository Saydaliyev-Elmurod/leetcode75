package leetcode75.hashMapSet.intersect;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        for (int j : nums2) {
            if (!set.add(j)) {
                result.add(j);
            }
        }
        int[] r = new int[result.size()];
        final int[] index = {0};
        result.forEach(i -> r[index[0]++] = i);
        return r;
    }
}