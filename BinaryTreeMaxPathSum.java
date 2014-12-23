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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer. MIN_VALUE};//if just using int, then could not be corrected?
        maxPathSum(root, maxSum);
        return maxSum[0];
    }
    public int maxPathSum(TreeNode root, int[] maxSum){
        if (root == null)
            return 0;
        int left = maxPathSum(root.left, maxSum);
        int right = maxPathSum(root.right, maxSum);
        int curr = Math.max(root.val, Math.max(left + root.val, right + root.val));
        maxSum[0] = Math.max(maxSum[0], Math.max(curr, left + root.val + right));
        return curr;//why return curr instead of maxSum[0]?
    }
}