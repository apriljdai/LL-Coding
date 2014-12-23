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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        //link list to another method
        eachLevel(root, list, 1);
        return list;
    }
    private void eachLevel(TreeNode a, ArrayList<ArrayList<Integer>> list, int depth){
        if(a == null)
            return;
        ArrayList<Integer> subList = new ArrayList<Integer>();
        subList.add(a.val);
        if(list.size() < depth)
            //add value in a new depth
            list.add(subList);
        else
            // add value in the same depth
            list.get(depth - 1).add(a.val);
        eachLevel(a.left, list, depth + 1);
        eachLevel(a.right, list, depth + 1);
    }
}