/*
 Symmetric Tree
 
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 
 For example, this binary tree is symmetric:
 
     1
    / \
   2   2
  / \ / \
 3  4 4  3
 But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;//remember!!
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null)
            return b == null;
        if(b == null)
            return false;
        if(a.val != b.val)
            return false;
        if(!isSymmetric(a.left, b.right))
            return false;
        if(!isSymmetric(a.right, b.left))
            return false;
        else
            return true;
    }
}