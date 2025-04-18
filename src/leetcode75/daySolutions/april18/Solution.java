package leetcode75.daySolutions.april18;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(45));
    }

    public String countAndSay(int n) {
        String res = "1";
        int count = 1;
        while (count++ < n) {
            res = count(res);
        }
        return res;
    }

    public String count(String s) {
        System.out.println(s);
        StringBuilder temp;
        StringBuilder res = new StringBuilder();
        String old = "" + s.charAt(0);
        temp = new StringBuilder(old);
        // 1212
        // 1112
        // 1111
        for (int i = 1; i < s.length(); i++) {
            if (old.equals("" + s.charAt(i))) {
                temp.append(old);
            } else {
                res.append(temp.length()).append(temp.charAt(0));
                old = "" + s.charAt(i);
                temp = new StringBuilder(old);
            }
        }
        res.append(temp.length()).append(temp.charAt(0));
        return res.toString();
    }
}