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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        return mergeKLists(lists, 0, lists.size() - 1);
    }
    public ListNode mergeKLists(List<ListNode> lists, int left, int right){
        while (left < right){
            int middle  = (left + right) / 2;
            return mergeKLists(mergeKLists(lists, left, middle), mergeKLists(lists, middle + 1, right));
        }
        return lists.get(left);//have to write this, or the method has no return value
    }
    public ListNode mergeKLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }
            else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 != null){
            res.next = l1;
        }
        if (l2 != null){
            res.next = l2;
        }
        return dummy.next;
    }
}//runtime: O(nklogk) space: O(logk)