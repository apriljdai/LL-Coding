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
    public TreeNode sortedArrayToBST(int[] number, int begin, int end){
        if (begin > end)
            return null;
        int middle = (begin + end) / 2;
        TreeNode root = new TreeNode(number[middle]);
        root.left = sortedArrayToBST(number, begin, middle - 1);
        //could not replace begin as 0, or time limited exceed
        //since not every time the begin equals to 0
        root.right = sortedArrayToBST(number, middle + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
}