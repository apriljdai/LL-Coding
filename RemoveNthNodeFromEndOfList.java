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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode a = head;
        ListNode b = head;
        //algorithm
        //a going to the nth list, a and b have gaps of n
        //a,b both going till a to the end of the list
        //b next is the list should be removed
        //use temp to delete that list
        for(int i = 0; i < n; i++){
            a = a.next;
        }
        if(a == null){
            head = head.next;
            return head;
        }
        while(a.next != null){
            a = a.next;
            b = b.next;
        }
        ListNode temp = b.next.next;
        b.next = temp;
        return head;
    }
}