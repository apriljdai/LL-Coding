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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        //no cycle happens
        if(fast != slow)
            return null;
        ListNode answer = head;
        //A = head, B = cycle begin, C = meet point
        //fast = a + b + c + b, slow = (a + b)
        //fast = 2 * slow => a + b + c + b = 2(a + b) => a = c
        while(fast != null && answer != null){
            if(fast == answer)
                break;
            fast = fast.next;
            answer = answer.next;
        }
        return answer;
    }
}