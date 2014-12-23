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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        return buildTree(inorder, 0, (inorder.length - 1), postorder, 0, (postorder.length - 1));
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd)
            return null;
        int rootVal = postorder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int length = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + length - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + length, postEnd - 1);
        return root;
    }
}