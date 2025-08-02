class Solution {
    public boolean backspaceCompare(String s, String t) {
        return clear(s).equals(clear(t));
    }

    public String clear(String s) {
        String s1 ="";
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '#') {
                s1 = s1.substring(0, Math.max(s1.length()- 1,0));
            } else {
                s1 += curr;
            }
        }
        return s1;
    }
}