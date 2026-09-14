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
    public ListNode reverseList(ListNode head) {
        //Maintain curr and prev pointers.
        ListNode prev = null;
        ListNode curr = head; //0
        while (curr != null) {
            ListNode next = curr.next; // null
            curr.next = prev;//3->2->1->0->null
            prev = curr; //3
            curr = next; //null
        }
        return prev;
        //For each iteration, set next->next to curr
    }
}
