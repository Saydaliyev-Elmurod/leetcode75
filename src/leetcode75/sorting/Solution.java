package leetcode75.sorting;

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        while (head.next != null) {
            ListNode next = head.next;
            if (next.val < head.val) {
                while (true) {
                    int a = head.val;
                    head.val = next.val;
                    next.val = a;
                    next.next = head;
                }
            }
        }
        return head;
    }
}