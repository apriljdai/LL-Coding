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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        ArrayList<TreeNode> visit = new ArrayList<TreeNode>();
        visit.add(root);
        boolean order = true;
        while (!visit.isEmpty()){
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (TreeNode node: visit){
                temp.add(node.val);
            }
            result.add(temp);
            for (int i = visit.size() - 1; i >= 0; i--){
                TreeNode node = visit.get(i);
                if(order){
                    if(node.right != null)
                        next.add(node.right);
                    if(node.left != null)
                        next.add(node.left);
                }
                else{
                    if(node.left != null)
                        next.add(node.left);
                    if(node.right != null)
                        next.add(node.right);
                }
            }
            //if order is the same with the initialization, then false, if not the same, then true
            order = order? false: true;
            visit = new ArrayList<TreeNode>(next);
        }
        return result;
    }
}