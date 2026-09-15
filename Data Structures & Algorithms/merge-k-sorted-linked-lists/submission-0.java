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
        ListNode head, curr;
        curr = new ListNode(0);
        head = curr;
        Queue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null) {
                heap.offer(list);
                lists[i] = list.next;
            }
        }
        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            curr.next = next;
            curr = next;
            if (next.next != null) {
                heap.offer(next.next);
            }
        }

        return head.next;
    }
}
