public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, result);
        return result;
    }
    private void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result){
        if (start >= num.length){
            ArrayList<Integer> item = temp(num);
            result.add(item);
        }
        for (int j = start; j < num.length; j++){
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }
    private ArrayList<Integer> temp(int[] num){
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int n: num)
            test.add(n);
        return test;
    }
    private void swap(int[] array, int start, int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}