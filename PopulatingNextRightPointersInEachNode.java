/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        if (root.right != null)
            root.right.next = findNext(root.next);
        if (root.left != null)
            root.left.next = root.right == null? findNext(root.next) : root.right;
        connect(root.right);
        connect(root.left);
    }
    public TreeLinkNode findNext(TreeLinkNode root){
        if (root == null)
            return null;
        TreeLinkNode result = null;
        TreeLinkNode temp = root;
        while (temp != null){
            if (temp.left != null){
                result = temp.left;
                break;
            }
            if (temp.right != null){
                result = temp.right;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
}