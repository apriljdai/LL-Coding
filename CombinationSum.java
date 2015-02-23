/*
 Combination Sum
 
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 
 The same repeated number may be chosen from C unlimited number of times.
 
 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        combinationSum(result, temp, candidates, target, 0, 0);
        return result;
    }
    public void combinationSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] candidates, int target, int step, int sum){
        if (sum == target){
            if (!result.contains(temp))
                result.add(new ArrayList<Integer>(temp));
            return;
        }
        if (sum > target)
            return;
        for (int i = step; i < candidates.length; i++){
            temp.add(candidates[i]);
            combinationSum(result, temp, candidates, target, i, sum + candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}