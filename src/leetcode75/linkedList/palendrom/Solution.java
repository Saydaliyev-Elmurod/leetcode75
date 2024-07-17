package leetcode75.linkedList.palendrom;

import leetcode75.linkedList.ListNode;

import java.util.Stack;

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
    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            Integer val = stack.pop();
            if (head.val != val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}