//package leetcode75.yandex.trenovka7.mh;
//
//import java.io.*;
//import java.util.Arrays;
//
//public class D {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] arr = reader.readLine().split(" ");
//        int n = Integer.parseInt(arr[0]);
//        int p = Integer.parseInt(arr[1]);
//        String[] a = reader.readLine().split(" ");
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(a[i]);
//        }
//        Arrays.sort(nums);
//        int min = Integer.MAX_VALUE;
//        int f = 0, s = 0;
//        for (int i = 0; i < n; i++) {--
//            int curr = nums[i];
//            int temp = calculateNear(i, nums, p);
//            int diff = Math.abs(nums[temp] -
//                    curr * p);
//            if (diff < min) {
//                min = diff;
//                f = curr;
//                s = nums[temp];
//            }
//        }
//        writer.write(f + " " + s);
//        reader.close();
//        writer.close();
//    }
//
//    private static int calculateNear(int i, int[] nums, int p) {
//        int left = i, right = nums.length - 1;
//        int min = Integer.MAX_VALUE;
//        while (left < nums.length && left <= right) {
//            int midd = left + (right - left) / 2;
//            if (Math.abs(nums[midd] - nums[i] * p) < min) {
//                right = midd - 1;
//                min = nums[midd] - nums[i] * p;
//            } else {
//                left = midd + 1;
//            }
//        }
//        return left;
//    }
//}
