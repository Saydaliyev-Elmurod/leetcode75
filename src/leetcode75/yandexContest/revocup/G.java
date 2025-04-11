package leetcode75.yandexContest.revocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while (testCases > 0) {
            testCases--;
            int numCount = Integer.parseInt(reader.readLine());
            String[] arr = reader.readLine().split(" ");
            Integer[] nums = new Integer[numCount];
            for (int i = 0; i < numCount; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            int left = numCount / 2 - 1;
            int right = left + 1;
            List<Integer> res = new ArrayList<>();
            while (left >= 0 && right < numCount) {
                res.add(nums[right]);
                res.add(nums[left]);
                right++;
                left--;
            }
            while (right < numCount) {
                res.add(nums[right]);
                right++;
            }
            while (left >= 0) {
                res.add(nums[left]);
                left--;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int response = 0;
            System.out.println(res);
            for (Integer re : res) {
                min = Math.min(min, re);
                max = Math.max(max, re);
                response += max - min;
            }
            System.out.println(response);
        }
    }


}

