/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    public ArrayList<TreeNode> generateTrees(int a, int b){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (a > b)
            res.add(null);
        if (a == b)
            res.add(new TreeNode(a));
        if (a < b){
            for (int i = a; i <= b; i++){
                ArrayList<TreeNode> left = generateTrees(a, i - 1);
                ArrayList<TreeNode> right = generateTrees(i + 1, b);
                for (TreeNode l: left){
                    for (TreeNode r: right){
                        TreeNode temp = new TreeNode(i);
                        temp.left = l;
                        temp.right = r;
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}