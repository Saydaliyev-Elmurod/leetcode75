package leetcode75.slingwindow.solutoin;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maximumSubarraySum(new int[] {1, 1, 1, 1, 1, 1}, 2));
  }

  public long maximumSubarraySum(int[] nums, int k) {
    int left = 0, right = k - 1;
    if (nums.length < k) return 0;
    long max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int invalid = 0;
    long curr = 0;
    for (int i = 0; i < k; i++) {
      Integer count = map.get(nums[i]);
      if (count == null) {
        map.put(nums[i], 1);
      } else {
        if (count == 1) {
          invalid++;
        }
        map.put(nums[i], count + 1);
      }
      curr += nums[i];
    }
    if (invalid <= 0) {
      max = curr;
    }
    while (right + 1 < nums.length) {
      int prev = nums[left];
      int next = nums[right + 1];
      Integer old = map.get(prev);

      if (old == 1) {
        map.remove(prev);
      } else {
        if (old == 2) {
          invalid--;
        }
        map.put(prev, old - 1);
      }
      Integer newItem = map.get(next);
      if (newItem == null) {
        map.put(next, 1);
      } else {
        if (newItem == 1) {
          invalid++;
        }
        map.put(next, newItem + 1);
      }
      curr = curr - prev + next;
      if (invalid <= 0) {
        max = Math.max(max, curr);
      }
      left++;
      right++;
    }
    return max;
  }
}
