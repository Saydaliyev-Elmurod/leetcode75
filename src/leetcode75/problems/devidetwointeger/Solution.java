package leetcode75.problems.devidetwointeger;

class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        boolean isOdd = (divisor > 0 && dividend < 0) || (dividend > 0 && divisor < 0);
        int multiple = isOdd ? -1 : 1;

        while ((dividend > 0 ? dividend : dividend * -1) >= (divisor > 0 ? divisor : divisor * -1)) {
            dividend = dividend + (-1 * multiple) * divisor;
            result += 1;
        }

        return result * multiple;
    }
}