public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] min = new int[row];
        //get the buttom array
        for (int i = 0; i < triangle.get(row - 1).size(); i++){
            min[i] = triangle.get(row - 1).get(i);
        }
        //compare the neighbor two integer and pick the smaller one then add to the top level
        for (int i = row - 2; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
            }
        }
        return min[0];
    }
}