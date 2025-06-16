package leetcode75.linkedList;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        largestNumber(new int[]{1, 3, 35, 30});
    }

    public static String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }
        return String.join("", arr);
    }

    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            list.add(i + "");
        }
        list.sort(String::compareTo);
        return list.stream().map(Integer::valueOf).toList();
    }

}
