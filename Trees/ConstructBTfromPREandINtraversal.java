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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd)
            return null;
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = 0; i <= inEnd; i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int length = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + length, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + length + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}