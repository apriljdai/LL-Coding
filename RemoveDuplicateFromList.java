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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newList = head;
        while(newList != null && newList.next != null){
            if(newList.val == newList.next.val)
                newList.next = newList.next.next;
            else
                newList = newList.next;
        }
        return head;
        //not return newList, newList is the end of the list
        //head still be the head of the revised list
    }
}