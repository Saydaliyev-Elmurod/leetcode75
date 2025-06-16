package leetcode75.contest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Router router = new Router(3);
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(2, 5, 90));
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(3, 5, 95));
        System.out.println(router.addPacket(4, 5, 105));
        System.out.println(Arrays.toString(router.forwardPacket()));
        System.out.println(router.addPacket(5, 2, 110));
        System.out.println(router.getCount(5, 100, 110));
        System.out.println(router.getCount(5, 0, 110));
//        Solution solution = new Solution();
//        System.out.println(solution.minimumPairRemoval(new int[]{1,3,2,5,6}));
    }
}
