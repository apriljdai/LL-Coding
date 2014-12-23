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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> returnNumber = new ArrayList<Integer>();
        if(root == null)
            return returnNumber;
        else{
            returnNumber.addAll(inorderTraversal(root.left));
            returnNumber.add(root.val);
            returnNumber.addAll(inorderTraversal(root.right));
        }
        return returnNumber;
    }
}