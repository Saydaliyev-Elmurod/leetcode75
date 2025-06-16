package leetcode75.graph.path;

import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        recursion(res, current, 0, graph);
        return res;
    }

    private void recursion(final List<List<Integer>> res, List<Integer> currentPath, final int current, final int[][] graph) {
        currentPath.add(current);
        if (current == graph.length - 1) {
            res.add(new ArrayList<>(currentPath));
        }

        for (int child : graph[current]) {
            recursion(res, currentPath, child, graph);
        }

        currentPath.remove(currentPath.size() - 1);


    }
}