package leetcode75.daySolutions.may30;

class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = 1;
            for (int j = i + 1; j < arr.length; j++) {
                b = arr[j];
                a = a ^ arr[j];
                for (int k = j; k < arr.length; k++) {
                    if (k != j) {
                        b = b ^ arr[k];
                    }
                }
            }
            if (a == b) {
                count++;
            }
        }
        return count;
    }
}