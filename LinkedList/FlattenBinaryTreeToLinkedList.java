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
    public void flatten(TreeNode root) {
        Stack<TreeNode> result = new Stack<TreeNode>();
        if (root == null)
            return;
        result.push(root);
        TreeNode temp = null;
        while (!result.isEmpty()){
            TreeNode node = result.pop();
            if (node.right != null)
                result.push(node.right);
            if (node.left != null)
                result.push(node.left);
            if (temp != null){
                temp.left = null;
                temp.right = node;
            }
            temp = node;
        }
    }
}