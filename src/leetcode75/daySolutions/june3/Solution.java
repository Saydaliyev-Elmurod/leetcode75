package leetcode75.daySolutions.june3;

class Solution {
    //https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
    public int appendCharacters(String s, String t) {
        int point = 0;
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            boolean isExist = false;
            for (int j = point; j < s.length(); j++) {
                if (s.charAt(j) == character) {
                    point = j + 1;
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                return t.length()-i;
            }
        }
        return 0;
    }
}