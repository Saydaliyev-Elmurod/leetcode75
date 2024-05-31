package leetcode75.daySolutions.may29;

class Solution {
    /**
     * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
     */
    public int numSteps(String s) {
        int len = s.length();
        double num = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(len - 1 - i);
            if (ch == '1') {
                num +=  Math.pow(2, i);
            }
        }
        int step = 0;
        while (num != 1) {
            step++;
            if (num % 2 == 0) {
                System.out.printf("%s x 2 = %s%n",num,num/2);
                num = num / 2;
            } else {
                System.out.printf("%s +1 = %s%n",num,num+1);
                num = (num + 1);
            }
        }
        return step;
    }
}