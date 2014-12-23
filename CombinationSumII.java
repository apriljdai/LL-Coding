public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return result;
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        combinationSum2(num, target, 0, result, temp);
        return result;
    }
    public void combinationSum2(int[] num, int target, int step, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        if (target == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if (target < 0 || step >= num.length)
            return;
        for (int i = step; i < num.length; i++){
            //avoid the duplicate solution of array
            if (i > step && num[i] == num[i - 1])
                continue;
            temp.add(num[i]);
            combinationSum2(num, target - num[i], i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}