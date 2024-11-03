package leetcode75.leetcode150.deleteList;

import leetcode75.linkedList.ListNode;

class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1,2,3,4 -> 2 -> 1,2,4
        int index = 1;
        ListNode node = head;
        while (head.next != null) {
            index++;
            head = head.next;
        }
        int i = 0;
        while (node.next != null) {
            if (i == index - n) {
                node.next = node.next.next;
                break;
            }
            i++;
        }
        return node;
    }
}