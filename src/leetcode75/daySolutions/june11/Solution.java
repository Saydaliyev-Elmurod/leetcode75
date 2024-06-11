package leetcode75.daySolutions.june11;

import java.util.*;
import java.util.stream.Stream;

class Solution {
    //https://leetcode.com/problems/relative-sort-array/description/
    //arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    //[2,2,2,1,4,3,3,9,6,7,19]

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr2) {
            queue.add(j);
        }

        for (int j : arr1) {
            map.put(j, map.getOrDefault(j,0 )+1);
        }
        int index = 0;
        for (Integer q : queue) {
            int val = map.get(q);
            for (int i = 0; i < val; i++) {
                arr1[index++] = q;
            }
            map.remove(q);
        }
        List<Integer> sorted = map.keySet().stream().sorted().toList();
        for (Integer j:sorted) {
            int val = map.get(j);
            for (int i = 0; i < val; i++) {
                arr1[index++] = j;
            }
            map.remove(j);
        }
        return arr1;
    }
}