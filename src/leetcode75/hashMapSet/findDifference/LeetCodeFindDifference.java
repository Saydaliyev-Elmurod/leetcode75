package leetcode75.hashMapSet.findDifference;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeFindDifference {
    public static void main(String[] args) {
        int[] nums1 = {-3,6,-5,4,5,5};
        int[] nums2 = {6,6,-3,-3,3,5};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = toListValue(nums1);
        List<Integer> list2 = toListValue(nums2);
        Set<Integer> list3 = new HashSet<Integer>();
        for (int a : list1) {
            if (!list2.contains(a)) list3.add(a);
        }
        Set<Integer> list4 = new HashSet<Integer>();
        for (int b : list2) {
            if (!list1.contains(b)) list4.add(b);
        }
        List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        arrayList.add(new ArrayList<Integer>(list3));
        arrayList.add(new ArrayList<Integer>(list4));
        return arrayList;
    }

    public static List<Integer> toListValue(int[] nums1) {
        return Arrays.stream(nums1).boxed().collect(Collectors.toList());
    }
}
