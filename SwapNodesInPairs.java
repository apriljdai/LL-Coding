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
    public ListNode swapPairs(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        return swapTwoInteger(head);
    }
    public ListNode swapTwoInteger(ListNode node){
        if(node == null|| node.next == null)
            return node;
        //in order to make the recursion
        ListNode next = node.next.next;
        
        //swap function
        ListNode temp = node;
        node = node.next;
        node.next = temp;
        
        //recursion
        node.next.next = swapTwoInteger(next);
        
        //return head
        return node;
    }
}