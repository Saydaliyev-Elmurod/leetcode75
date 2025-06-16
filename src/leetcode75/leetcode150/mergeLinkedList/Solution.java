package leetcode75.leetcode150.mergeLinkedList;

import leetcode75.linkedList.ListNode;

import java.util.List;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode res = head;
        ListNode node;
        while (list1 != null && list2 != null) {
            int val = list1.val;
            int val2 = list2.val;
            if (val > val2) {
                node = new ListNode(val2);
                head.next = node;
                head = head.next;
                list2 = list2.next;
            } else {
                node = new ListNode(val);
                head.next = node;
                head = head.next;
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            node = new ListNode(list1.val);
            head.next = node;
            head = head.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            node = new ListNode(list2.val);
            head.next = node;
            head = head.next;
            list2 = list2.next;
        }
        return res.next;
    }
}