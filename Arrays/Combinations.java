/*
 Combinations
 
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 
 For example,
 If n = 4 and k = 2, a solution is:
 
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        //boundary case, if n < k, then there's no possible solution
        if (n < k)
            return result;
        combine(n, k, result, temp, 1);
        return result;
    }
    public void combine(int n, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int start){
        if (temp.size() == k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        else{
            for (int i = start; i <= n; i++){
                temp.add(i);
                combine(n, k, result, temp, i + 1);
                temp.remove(temp.size() - 1);//Removes the element at the specified position in this list.
            }
        }
    }
}