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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> returnNumber = new ArrayList<Integer>();
        if(root == null)
            return returnNumber;
        else{
            returnNumber.addAll(postorderTraversal(root.left));
            returnNumber.addAll(postorderTraversal(root.right));
            returnNumber.add(root.val);
        }
        return returnNumber;
    }
}