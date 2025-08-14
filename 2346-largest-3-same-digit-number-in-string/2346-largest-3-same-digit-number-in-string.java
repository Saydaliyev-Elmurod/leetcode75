class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        String res = "";
        for (int i = 3; i <= num.length(); i++) {
            String temp = num.substring(i - 3, i);
            if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2)) {
                if (Integer.valueOf(temp) > max) {
                    res = temp;
                    max = Integer.valueOf(temp);
                }
            }
        }
        return res;

    }
}