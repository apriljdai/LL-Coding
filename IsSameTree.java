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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        // wrong(p.val == null) because integer cannot be null;
            return true;
        else if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            else
                return false;
        }
        else
            return false;
    }
}