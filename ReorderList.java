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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //devide list into two lists
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;//so as to devide two lists
        //reverse the list2
        l2 = reverseList(l2);
        //combine two lists
        ListNode res = l1;
        while(l1 != null && l2 != null){
            ListNode temp = l2;
            l2 = temp.next;
            temp.next = l1.next;
            l1.next = temp;
            l1 = temp.next;
        }
    }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;//have to write the base case, or runtime error
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;
        return pre;
    }
}