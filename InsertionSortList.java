/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        ListNode curr = head;
        while (curr != null){
            pre = res;
            ListNode next = curr.next;
            while (pre.next != null && pre.next.val < curr.val)
                pre = pre.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return res.next;
    }
}