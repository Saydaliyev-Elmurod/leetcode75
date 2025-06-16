package leetcode75.stack.gamewinner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    //https://leetcode.com/problems/find-the-winner-of-the-circular-game/
    public int findTheWinner(int n, int k) {
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            first.add(i);
        }
        int point = 0;
        while (!first.isEmpty()) {
            if ((point + 1) % k == 0) {
                first.poll();
            } else {
                second.add(first.poll());
            }
            point++;
            if (first.isEmpty()) {
                first = second;
                if (second.size() == 1) {
                    return second.poll();
                }
                second = new LinkedList<>();
            }

        }
        return 0;
    }
}