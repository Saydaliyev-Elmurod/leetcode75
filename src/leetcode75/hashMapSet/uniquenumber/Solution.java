package leetcode75.hashMapSet.uniquenumber;

import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    //https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        map.values().forEach(integer -> map2.put(integer, integer));
        return map2.size() == map.size();
    }
}