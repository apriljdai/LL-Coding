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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        reverseLevel(root, 1, levels);
        //reverse all the things in the arraylist
        Collections.reverse(levels);
        return levels;
    }
    private void reverseLevel(TreeNode a, int height, ArrayList<ArrayList<Integer>> levels){
        ArrayList<Integer> subLevel = new ArrayList<Integer>();
        if (a == null)
            return;
        subLevel.add(a.val);
        if(height >  levels.size())
            levels.add(subLevel);
        else
            levels.get(height - 1).add(a.val);
        reverseLevel(a.left, height + 1, levels);
        reverseLevel(a.right, height + 1, levels);
    }
}