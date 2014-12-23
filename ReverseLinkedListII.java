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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //one space: could not creat a list, just change
        ListNode mNode = head;
        ListNode nNode = head;
        ListNode mPre = new ListNode(0);
        mPre.next = head;
        for (int i = 0; i < n - m; i++){
            nNode = nNode.next;
        }
        for (int i = 0; i < m - 1; i++){
            mPre = mNode;
            mNode = mNode.next;
            nNode = nNode.next;
        }
        //check if mNode is the head since if mNode is the head, then we'll return nNode instead of head;
        boolean check = false;
        if (mNode == head)
            check = true;
        while (nNode != mNode){
            //put the mNode after the nNode
            ListNode temp = nNode.next;
            nNode.next = mNode;
            mPre.next = mNode.next;
            mNode.next = temp;
            //make mNode to the mPre.next
            mNode = mPre.next;
        }
        if (check == true)
            return nNode;
        return head;
    }
}