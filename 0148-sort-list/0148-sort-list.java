/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        List<Integer> nums = new ArrayList<>();
        while (head.next != null) {
            nums.add(head.val);
            head = head.next;
        }
        nums.add(head.val);
        Collections.sort(nums);
        ListNode node = new ListNode();
        head = node;
        for (Integer num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }
}