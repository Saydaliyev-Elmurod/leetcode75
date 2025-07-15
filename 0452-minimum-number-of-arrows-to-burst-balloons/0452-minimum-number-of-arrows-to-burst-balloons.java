class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int end = points[0][1];
        if (points.length == 1)
            return 1;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            // 1,10 2,3
            // 1,10 1,12
            // 1,10 12,13
            // 1,10 4,12
            if (end >= curr[0]) {
                if (end > curr[1]) {
                    end = curr[1];
                }
            } else {
                count++;
                end = curr[1];
            }
        }
        return count + 1;
    }
}