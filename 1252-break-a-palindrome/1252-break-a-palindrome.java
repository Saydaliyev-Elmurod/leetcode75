class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        String res = "";
        // aaa
        // aba
        boolean isa = true;
        for (int i = 0; i < n; i++) {

            char ch = palindrome.charAt(i);
            if (ch != 'a') {
                String next = palindrome.substring(Math.min(i + 1, n));
                if (next.equals(res)) {
                    return res + ch + next.substring(0, next.length() - 1) + 'b';

                }
                return res + 'a' + palindrome.substring(Math.min(i + 1, n));
            }
            if (ch == 'a' && i == n - 1) {
                return res + 'b';
            }
            res += ch;
        }
        return res;
    }
}