package leetcode75.leetcode150.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 1,2,3
    // 3,4,5
    // 6,7,8
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        while (true) {
            int x = 0;
            int y = 0;
            // 0->n
            for (int i = y; i < n - y; i++) {
                list.add(matrix[x][i]);
            }
            for (int i = x; i < m - x; i++) {
                list.add(matrix[i][n]);
            }
            for (int i = n - y; i > y; i--) {
                list.add(matrix[i][n]);
            }
            for (int i = 0; i < n; i++) {
                list.add(matrix[i][n]);
            }
        }
    }
}