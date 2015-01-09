/*
 Linked List Cycle
 Given a linked list, determine if it has a cycle in it.
 
 Follow up:
 Can you solve it without using extra space?
 */

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
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            //must confirm current first, then check if next exists.
            if(fast.next != null)
                fast = fast.next.next;
            else
                return false;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
//two pointer chasing, if fast meet slow, then has a cirle.