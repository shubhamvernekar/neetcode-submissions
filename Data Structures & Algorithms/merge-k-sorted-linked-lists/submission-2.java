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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0, null);
        ListNode curr = dummy;

        int n = lists.length;

        while(n > 0) { 
            ListNode smallest = new ListNode(Integer.MAX_VALUE, null);
            int idx = 0;
            int remaining_count = 0;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                    continue;
                }
                remaining_count++;
                if(smallest.val > lists[i].val) {
                    smallest = lists[i];
                    idx = i;
                }
            }
            n = remaining_count;

            if(smallest.val == Integer.MAX_VALUE) {
                break;
            }

            lists[idx] = smallest.next;
            smallest.next = null;
            curr.next = smallest;
            curr = curr.next;
        }

        return dummy.next;
    }
}
