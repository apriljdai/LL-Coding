/*
Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//base case
        if (headA == null || headB == null)
            return null;

        //get the length difference of two lists
        int alen = getLength(headA);
        int blen = getLength(headB);
        if (blen > alen){
            int temp = alen;
            alen = blen;
            blen = temp;
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        int diff = alen - blen;

        //let two lists end at the same time
        while (diff-- > 0){
            headA = headA.next;
        }
        while (headA != null && headB != null){
            if (headA.val == headB.val)
                return headA;
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
    public int getLength(ListNode node){
        int count = 0;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }
}