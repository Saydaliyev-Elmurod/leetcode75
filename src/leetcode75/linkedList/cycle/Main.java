package leetcode75.linkedList.cycle;

import leetcode75.sorting.ListNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        solution.hasCycle(node);
    }
}
