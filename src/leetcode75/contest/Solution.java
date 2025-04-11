package leetcode75.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        final List<Integer> numbers = new ArrayList<>(Arrays.stream(nums)
                .boxed()
                .toList());

        while (!isSorted((numbers))) {
            int sum = Integer.MAX_VALUE;
            int min1 = 0;
            int min2 = 0;
            count++;
            for (int i = 1; i < numbers.size(); i++) {
                int temp = numbers.get(i) + numbers.get(i - 1);
                if (temp < sum) {
                    min1 = i;
                    min2 = i - 1;
                }
                sum = Math.min(sum, temp);
            }
            numbers.remove(min1);
            numbers.remove(min2);
            numbers.add(min2,sum);
        }
        return count;
    }

    public boolean isSorted(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}