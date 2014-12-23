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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carry = 0;
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (list1 != null || list2 != null){
            if (list1 != null){
                carry += list1.val;
                list1 = list1.next;
            }
            if (list2 != null){
                carry += list2.val;
                list2 = list2.next;
            }
            temp.next = new ListNode(carry % 10);
            temp = temp.next;
            carry = carry / 10;
        }
        if (carry == 1){
            temp.next = new ListNode(1);
        }
        return result.next;
    }
}