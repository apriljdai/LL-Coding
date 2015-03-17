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
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode list1 = head;
        while (list1.next != null){
            ListNode list2 = list1.next;
            while (list2.next != null && list2.val == list2.next.val){
                list2 = list2.next;
            }
            if (list2 != list1.next)
                list1.next = list2.next;
            else
                list1 = list1.next;
        }
        return head.next;
    }
}