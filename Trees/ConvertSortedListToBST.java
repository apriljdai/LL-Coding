/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode treeHead;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        treeHead = head;
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return sortedListToBST(0, length - 1);
    }
    public TreeNode sortedListToBST(int start, int end){
        if (start > end)
            return null;
        int middle = (start + end) / 2;
        //build the left node first
        TreeNode left = sortedListToBST(start, middle - 1);
        //build the root of the tree
        TreeNode root = new TreeNode(treeHead.val);
        root.left = left;
        //build the right of the tree
        treeHead = treeHead.next;
        root.right = sortedListToBST(middle + 1, end);
        return root;
    }
}