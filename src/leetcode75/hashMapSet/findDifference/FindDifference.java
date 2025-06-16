package leetcode75.hashMapSet.findDifference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDifference {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75

        int[] nums1 = {-3,6,-5,4,5,5};
        int[] nums2 = {6,6,-3,-3,3,5};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.add(nums2[i])) {
                list2.add(nums2[i]);
            } else {
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(j).equals(nums2[i])) {
                        list1.remove(j);
                        j--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        set.clear();
        for(int i = 0;i<list1.size();i++){
            set.add(list1.get(i));
        }
        result.add(set.stream().toList());
        result.add(list2);
        return result;

    }
}
