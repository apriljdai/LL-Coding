/*
 Binary Tree Level Order Traversal
 
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 
 For example:
 Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
*/

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
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        
        eachLevel(root, res, 1);
        return res;
    }
    public void eachLevel(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (root == null)
            return;
        temp.add(root.val);
        if (res.size() < depth)
            res.add(temp);
        else
            res.get(depth - 1).add(root.val);
        eachLevel(root.left, res, depth + 1);
        eachLevel(root.right, res, depth + 1);
    }
}