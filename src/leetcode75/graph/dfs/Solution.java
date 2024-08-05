package leetcode75.graph.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] used = new boolean[n];
        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        return dfs(arr, used, source, destination);

    }

    private boolean dfs(final List<Integer>[] arr, final boolean[] used, final int vertex, final int destination) {
        used[vertex] = true;
        System.out.println("Visit " + vertex);
        for (int neighbour : arr[vertex]) {
            if (neighbour == destination) {
                return true;
            }
            if (!used[neighbour]) {
                return dfs(arr, used, neighbour, destination);
            }
        }
        return false;
    }
}