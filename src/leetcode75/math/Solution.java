package leetcode75.math;

class Solution {
    //[[1,2,3],
    // [4,5,6],
    // [7,8,9]]
    //[[7,4,1],
    // [8,5,2],
    // [9,6,3]]

    //[[5,1,9,11],
    // [2,4,8,10],  (0,0)->(0,3)
    // [13,3,6,7],
    // [15,14,12,16]]

    //[[15,13,2,5],
    // [14,3,4,1],
    // [12,6,8,9],
    // [16,7,10,11]]
    //
    public void rotate(int[][] matrix) {
        int imax = matrix.length;
        for (int i = 0; i < imax; i++) {
            for (int j = 0; j < imax; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[imax - 1 - j][imax - 1 - i];
                matrix[imax - 1 - j][imax - 1 - i] = a;
            }
        }
    }
}