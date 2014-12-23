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
        if(root == null){
            return;
        }
        if(root.right!=null){
            root.right.next = findNext(root.next);
        }
        if(root.left!=null){
            root.left.next = root.right==null?findNext(root.next):root.right;
        }
        connect(root.right);
        connect(root.left);
    }
    public TreeLinkNode findNext(TreeLinkNode root){
        if(root==null){
            return null;
        }else{
            TreeLinkNode iter = root;
            TreeLinkNode result = null;
            while(iter!=null){
                if(iter.left!=null){
                    result = iter.left;
                    break;
                }
                if(iter.right!=null){
                    result = iter.right;
                    break;
                }
                iter = iter.next;
            }
            return result;
        }
    }
}