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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnNumber = new ArrayList<Integer>();
        if(root == null)
            return returnNumber;
        else{
            returnNumber.add(root.val);
            returnNumber.addAll(preorderTraversal(root.left));
            returnNumber.addAll(preorderTraversal(root.right));
            //recursion, so for the end of recursion there will be a val.
            //addAll method, add until the end of the list
        }
        return returnNumber;
    }
}