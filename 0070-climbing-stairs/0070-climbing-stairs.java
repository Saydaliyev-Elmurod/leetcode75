class Solution {
    int result = 0;

    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        int prev1 = 2;
        int prev2 = 3;
        for (int i = 4; i <= n; i++) {
            int temp = prev2;
            prev2= prev1+prev2;
            prev1=temp;
        }
        return prev2;
    }
}
