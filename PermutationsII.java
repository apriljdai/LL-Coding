public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }
    private void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result){
        if (start >= num.length){
            ArrayList<Integer> item = temp(num);
            result.add(item);
        }
        for (int j = start; j < num.length; j++){
            if (containDuplicate(num, start, j)){
                swap(num, start, j);
                permuteUnique(num, start + 1, result);
                swap(num, start, j);
            }
        }
        
    }
    private ArrayList<Integer> temp(int[] num){
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int n: num){
            test.add(n);
        }
        return test;
    }
    private boolean containDuplicate(int[] array, int start, int end){
        for (int i = start; i < end; i++){
            if (array[i] == array[end])
                return false;
        }
        return true;
    }
    private void swap(int[] array, int start, int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}