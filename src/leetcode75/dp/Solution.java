package leetcode75.dp;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
  }

  /**  @param @1911 */
  public long maxAlternatingSum(int[] nums) {
    // a1,a2,a3,a4,....an;
    // 1 <= nums.length <= 10^5
    // 1 <= nums[i] <= 10^5

    return 1;
  }

  public int maxRepeating(String sequence, String word) {
    int count = 0;
    String temp = "";
    int max = 0;
    for (char ch : sequence.toCharArray()) {
      temp += ch;
      if (!word.startsWith(temp)) {
        temp = "";
        count = 0;
      } else if (word.equals(temp)) {
        count++;
        temp = "";
        max = Math.max(max, count);
      }
    }
    max = Math.max(max, count);

    return max;
  }
}
