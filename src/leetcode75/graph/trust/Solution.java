package leetcode75.graph.trust;

import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> ishonadi = new HashMap<>();
        HashMap<Integer, List<Integer>> ishonishadi = new HashMap<>();
        for (int[] edge : trust) {
            List<Integer> trustList = ishonadi.getOrDefault(edge[0], new ArrayList<>());
            trustList.add(edge[1]);
            ishonadi.put(edge[0], trustList);

            List<Integer> ishongan = ishonishadi.getOrDefault(edge[1], new ArrayList<>());
            ishongan.add(edge[0]);
            ishonishadi.put(edge[1], ishongan);
        }
        Optional<Map.Entry<Integer, List<Integer>>> first = ishonishadi.entrySet().stream().filter(entry -> entry.getValue().size() == n - 1).findFirst();
        if (first.isEmpty()) {
            return -1;
        }

        Integer key = first.get().getKey();
        Optional<Map.Entry<Integer, List<Integer>>> any = ishonadi.entrySet().stream().filter(entry -> !entry.getValue().contains(key)).findAny();
        if (any.isPresent()) {
            return -1;
        }
        return key;

    }
}