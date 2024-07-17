package leetcode75.linkedList.palendrom;

import leetcode75.linkedList.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(1);
        head.next=first;
        first.next=second;
        solution.isPalindrome(head);
    }
}
