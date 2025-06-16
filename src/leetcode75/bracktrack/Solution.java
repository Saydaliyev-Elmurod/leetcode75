package leetcode75.bracktrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    static Set<List<Integer>> result;

    public static List<List<Integer>> subsets(int[] nums) {
        result = new HashSet<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                result.add(new ArrayList<>(list));
                list.add(nums[j]);
            }
            result.add(new ArrayList<>(list));
            // 1,2,3,4,5
        }
        return new ArrayList<>(result);
    }

}