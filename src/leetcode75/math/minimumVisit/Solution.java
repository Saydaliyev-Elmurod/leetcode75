package leetcode75.math.minimumVisit;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int len = 0;
        for (int i = 1; i < points.length; i++) {
            int ax = points[i - 1][0];
            int ay = points[i - 1][1];
            int bx = points[i][0];
            int by = points[i][1];
            len += Math.max(Math.abs(ax - bx), Math.abs(ay - by));
        }
        return len;
    }
}