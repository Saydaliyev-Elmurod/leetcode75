package leetcode75.bracktrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4, new int[]{5, 1, 6, 2}));
    }

    public int climbStairs(int n, int[] costs) {

        if (n <= 0) return 0;
        if (map.containsKey(n)) return map.get(n);

        int n1 = map.getOrDefault(n - 1, climbStairs(n - 1, costs)) + costs[n - 1] + 1;
        int n2;
        n2 = map.getOrDefault(n - 2, climbStairs(n - 2, costs)) + costs[n - 1] + 4;

        int n3;
        n3 = map.getOrDefault(n - 3, climbStairs(n - 3, costs)) + costs[n - 1] + 9;

        int min = Math.min(n1, Math.min(n2, n3));
        map.put(n, min);
        return min;
    }
}