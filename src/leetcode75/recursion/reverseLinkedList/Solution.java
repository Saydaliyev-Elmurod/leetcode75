package leetcode75.recursion.reverseLinkedList;

import leetcode75.linkedList.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1,2,3,4,5
        if(head==null||head.next==null) return head;
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next= head;
        return  second; 
    }
}