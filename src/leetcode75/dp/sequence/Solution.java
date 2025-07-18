package leetcode75.dp.sequence;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
  }

  public int maxRepeating(String sequence, String word) {
    int firstIndex = sequence.indexOf(word);
    if (firstIndex == -1) return 0;
    int count = 0;
    int max = 0;
    int n = word.length();
    while (firstIndex != -1 && firstIndex < sequence.length()) {
      String temp = sequence.substring(firstIndex, Math.min(firstIndex + n, sequence.length()));
      if (temp.equals(word)) {
        count++;
        firstIndex = firstIndex + n;
      } else {
        max = Math.max(max, count);
        count = 0;
        sequence = sequence.substring(firstIndex-n+1);
        firstIndex = sequence.indexOf(word);
      }
    }
    max = Math.max(max, count);
    return max;
  }
}
