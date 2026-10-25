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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow give the mid point then after mid+1 save it
        //and disconnect the original
        ListNode secHalf = slow.next;
        slow.next = null;

        //rev the secHalf
        ListNode curr = secHalf;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }

        //Now we have rev secHaf in prev
        //and the first half of original 
        //start reordering : alternatively adding
        while(prev != null){
            //store the next val
            ListNode firstHalfNext = head.next;
            ListNode secHalfNext = prev.next;

            head.next = prev;
            prev.next = firstHalfNext;

            head = firstHalfNext;
            prev = secHalfNext;
        }
    }
}
