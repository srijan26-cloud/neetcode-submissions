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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        //move 'fast' to n+1
        for(int i=0;i<= n;i++){
            if(fast == null)
                return head;
            fast = fast.next;
        } 

        //move fast & slow at same pase till fast reach null ptr.
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //now slow-> next will be the node to be deleted
        ListNode toBeDele = slow.next;

        //eleminate it by skipping it
        if(toBeDele != null){
            slow.next = toBeDele.next;
        }

        return dummy.next;
    }
}
