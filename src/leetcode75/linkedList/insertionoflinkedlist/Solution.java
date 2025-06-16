package leetcode75.linkedList.insertionoflinkedlist;

import leetcode75.linkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        while (headA.val!=headB.val) {
            headA = headA.next;
            headB = headB.next;
            if(headA==null||headB==null) return null;
        }
        return headA;
    }
}