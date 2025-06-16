class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1)
            return false;

        return findTarget(matrix[row], target);
    }

    private boolean findTarget(final int[] matrix, final int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (matrix[middle] == target) {
                return true;
            } else if (matrix[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    private int findRow(final int[][] matrix, final int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (matrix[middle][0] <= target && matrix[middle][matrix[middle].length - 1] >= target) {
                return middle;
            } else if (matrix[middle][0] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}