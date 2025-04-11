package leetcode75.contest;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
//        solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5});
        solveQueries(new int[]{2, 10, 20, 20, 20}, new int[]{1, 4, 2});
    }


    static Map<Integer, List<Integer>> indexMap = new HashMap<>();

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        generateData(nums);
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i];
            res.add(findMin(n, nums));
        }
        return res;
    }

    public static void generateData(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final List<Integer> indexes = indexMap.getOrDefault(nums[i], new ArrayList<>());
            indexes.add(i);
            indexMap.put(nums[i], indexes);
        }
    }

    public static int findMin(int index, int[] nums) {
        int len = nums.length;
        final List<Integer> indexs = indexMap.getOrDefault(nums[index], new ArrayList<>());
        if (indexs.isEmpty() || indexs.size() == 1) return -1;
        boolean isFind = false;
        int min = Integer.MAX_VALUE;
        for (int i : indexs) {
            if (i == index) {
                isFind = true;
            } else if (isFind) {
                min = i - index;
                break;
            }
        }
        if (isFind) {
            return Math.min(len - index + indexs.getFirst(), min);
        }
        return -1;
    }
}
