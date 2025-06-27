class Solution {
    public int longestSubsequence(String s, int k) {
        while (toDec(s) > k) {
            s = removeFirst(s);
        }
        return s.length();
    }

    public String removeFirst(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return s.substring(0, i) + s.substring(Math.min(i + 1,s.length()));
            }
        }
        return s;
    }

    // 1001
    public int toDec(String s) {
        int index = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, index);
            }
            index++;
        }
        return sum;
    }
}