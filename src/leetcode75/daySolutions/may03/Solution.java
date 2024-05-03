package leetcode75.daySolutions.may03;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return -1;
            } else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                return 1;
            }
        }
        boolean isOne = (arr1.length > arr2.length);
        if (isOne) {
            for (int i = arr2.length; i < arr1.length; i++) {
                if (Integer.parseInt(arr1[i]) < 0) {
                    return -1;
                } else if (Integer.parseInt(arr1[i]) >0) {
                    return 1;
                }
            }
        }
        for (int i = arr1.length; i < arr2.length; i++) {
            if (Integer.parseInt(arr2[i]) < 0) {
                return 1;
            } else if (Integer.parseInt(arr2[i]) > 0) {
                return -1;
            }
        }
        return 0;
    }
}