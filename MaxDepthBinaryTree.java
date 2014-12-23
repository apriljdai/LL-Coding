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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int lResult = maxDepth(root.left);
        int rResult = maxDepth(root.right);
        if(lResult > rResult)
            return lResult + 1;
        else
            return rResult + 1;
    }
}