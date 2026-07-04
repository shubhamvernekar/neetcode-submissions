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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int i = 0;
        ListNode prev = null;
        while(i < n) {
            fast = fast.next;
            i++;
        }

        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head) return slow.next;
        prev.next = slow.next;

        return head;
    }
}
