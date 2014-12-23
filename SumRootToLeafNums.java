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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return getSum(root, 0, 0);
    }
    private int getSum(TreeNode node, int num, int sum){
        if(node == null)
            return sum;
        num = num * 10 + node.val;
        if(node.left == null && node.right == null){
            sum += num;
            //if not return here, the sum value will be doubled.
            return sum;
        }
        sum = getSum(node.left, num, sum) + getSum(node.right, num, sum);
        return sum;
    }
}