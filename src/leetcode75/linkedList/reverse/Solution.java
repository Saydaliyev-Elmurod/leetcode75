package leetcode75.linkedList.reverse;

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
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        while (true){
            ListNode first = head;
            head = head.next;
            while (head.next!=null){
            }
        }
    }
}