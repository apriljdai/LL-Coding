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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        else
            //if not say this, one possible case maybe happen when the most left and most right subtree are balanced and others are not
            return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root){
        if (root == null)
            return 0;
        else
            //return the longest subtree value
            return (Math.max(height(root.left), height(root.right))) + 1;
    }
}