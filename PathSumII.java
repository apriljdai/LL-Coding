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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        pathSum(root, sum, result, temp);
        return result;
    }
    public void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        if (root == null)
            return;
        int currentVal = root.val;
        temp.add(currentVal);
        if (root.left == null && root.right == null){
            if (sum - currentVal == 0){
                ArrayList<Integer> current = new ArrayList<Integer>(temp);
                result.add(current);
            }
        }
        pathSum(root.left, sum - currentVal, result, temp);
        pathSum(root.right, sum - currentVal, result, temp);
        //time limited exceeded if without remove, what exactly did temp remove?
        temp.remove(temp.size() - 1);
    }
}