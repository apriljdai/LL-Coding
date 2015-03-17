public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return result;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for (int i = num.length - 1; i >= 0; i--){
            //get the existing array in result
            if (i == num.length - 1 || num[i] != num[i + 1] || temp.size() == 0){
                temp = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++){
                    temp.add(new ArrayList<Integer>(result.get(j)));
                }
            }
            //add one element to temp
            for (ArrayList<Integer> a: temp)
                a.add(0, num[i]);
            //add the new single number to the temp
            if (i == num.length - 1 || num[i] != num[i + 1]){//have to write "i == num.length - 1" at first, or the runtime will be exceeded
                ArrayList<Integer> test = new ArrayList<Integer>();
                test.add(num[i]);
                temp.add(test);
            }
            //add all the arrays in the temp into result
            for (ArrayList<Integer> a: temp){
                result.add(new ArrayList(a));
            }
        }
        //add the empty block at the end of the arrayList
        result.add(new ArrayList<Integer>());
        return result;
    }
}