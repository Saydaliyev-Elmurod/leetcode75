//package leetcode75.leetcode150.binaryMatrix;
//
//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        // 4 4
//        // 1  2  3  4
//        // 5  6  7  8
//        // 9  10 11 12
//        // 13 14 15 16
//        int leftN = 0;
//        int rightN = n / 2;
//        int leftM = 0;
//        int rightM = m / 2;
//        while () {
//            if (matrix[tempN][tempM] == target) {
//                return true;
//            } else if (matrix[tempN][tempM] > target) {
//                tempM = tempN / 2;
//                tempN = tempN / 2;
//            } else {
//                tempM = tempN / 2;
//                tempN = tempN / 2;
//            }
//        }
//        return false;
//    }
//}