package leetcode75.linkedList.insertgreatestcommondivisor;

import leetcode75.sorting.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(18);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution();
        System.out.println(solution.insertGreatestCommonDivisors(node));
    }
}
