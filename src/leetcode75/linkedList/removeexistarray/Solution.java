package leetcode75.linkedList.removeexistarray;

import leetcode75.linkedList.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;
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
    public static void main(String[] args) {

    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Queue<Integer> queue = new PriorityQueue<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }
        for (int num : nums) {
            queue.remove(num);
        }
        if (queue.isEmpty()) return null;
        ListNode node = new ListNode(queue.poll());
        ListNode current = node;
        while (!queue.isEmpty()) {
            current.next = new ListNode(queue.poll());
            current = current.next;
        }
        return node;
    }
}