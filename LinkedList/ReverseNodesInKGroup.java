/*
Reverse Nodes

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode curr = head;
        
        int count = 0;
        while (curr != null){
            count++;
            ListNode next = curr.next;
            if (count == k){
                pre = reverse(pre, next);
                count = 0;
            }
            curr = next;
        }
        return res.next;
    }
    //       1 ->  2 ->  3 ->  4  ->  5
    //pre->head->             curr->next
    //       3 ->  2 ->  1
    
    //reverse k nodes in-place
    public ListNode reverse(ListNode begin, ListNode end){
        if (begin == null || begin.next == null)
            return begin;
        ListNode head = begin.next;
        ListNode curr = begin.next.next;
        while (curr != end){
            ListNode next = curr.next;  
            curr.next = begin.next;  
            begin.next = curr;  
            curr = next; 
        }
        head.next = end;
        return head;
    }
}