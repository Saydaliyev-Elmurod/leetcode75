package leetcode75.linkedList.insertgreatestcommondivisor;

import leetcode75.sorting.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // 18,6,10,3
        ListNode flag = head;
        while (flag.next!= null) {
            ListNode old = flag.next;
            ListNode listNode = new ListNode(EKUK(flag.val, flag.next.val)); // 6
            flag.next = listNode;
            listNode.next = old;
            flag = listNode.next;
        }
        return head;
    }

    public int EKUK(Integer a1, Integer a2) {
        int a = Math.min(a1, a2);
        int r = 1;
        for (int i = 2; i <= a; i++) {
            if (a1 % i == 0 && a2 % i == 0) {
                r = i;
            }
        }
        return r;
    }
}