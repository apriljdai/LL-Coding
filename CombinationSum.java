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
            temp.remove(temp.size() - 1);//what's that for?
        }
    }
}