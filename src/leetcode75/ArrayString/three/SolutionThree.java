package leetcode75.ArrayString.three;

import java.util.ArrayList;
import java.util.List;

public class SolutionThree {
    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        ArrayList<Boolean> arr = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            arr.add(candies[i] + extraCandies >= max);
        }
        return arr;
    }
}
