package leetcode75;
//https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public static void main(String[] args) {
        largestAltitude(new int[]{-5, 1, 5, 0, -7});
    }

    public static int largestAltitude(int[] gain) {
        int[] res = new int[gain.length + 1];
        int max = 0;
        for (int i = 1; i < res.length; i++) {
            // res[i+1]-res[i]=gain[i]
            res[i] = gain[i - 1] + res[i - 1];
            max = Math.max(res[i], max);
        }
        return max;
    }
}