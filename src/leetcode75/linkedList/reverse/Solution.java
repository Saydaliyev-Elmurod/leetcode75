package leetcode75.linkedList.reverse;

import leetcode75.linkedList.ListNode;

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
        // 1->2->3->4->null
        //
        // ListNode current= head;
        // ListNode previous= null;
        // while(current!=null){
        // ListNode next = current.next;
        // current.next = previous;
        // previous=current;
        // current = next;
        // }
        // return previous;

        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = new ListNode(current.val);
            temp.next = prev;
            prev = temp;
            current = current.next;
        }
        return prev;
    }
}