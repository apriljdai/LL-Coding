/*
 Binary Tree Level Order Traversal II
 
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 
 For example:
 Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        
        eachLevel(root, res, 1);
        Collections.reverse(res);
        return res;
    }
    public void eachLevel(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth){
        if (root == null)
            return;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        if (res.size() < depth)
            res.add(temp);
        else
            res.get(depth - 1).add(root.val);
        eachLevel(root.left, res, depth + 1);
        eachLevel(root.right, res, depth + 1);
    }
    
}