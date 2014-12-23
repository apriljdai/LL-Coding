/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode res = new ListNode(0);
        ListNode follow = res;
        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                follow.next = head1;
                head1 = head1.next;
            }
            else{
                follow.next = head2;
                head2 = head2.next;
            }
            follow = follow.next;
        }
        if (head1 != null)
            follow.next = head1;
        if (head2 != null)
            follow.next = head2;
        return res.next;
    }
}