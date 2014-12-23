public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; i++){
            ArrayList<Integer> subList = new ArrayList<Integer>();
            // the most left one is always 1
            subList.add(1);
            if (i > 0){
                for (int j = 0; j < list.get(i - 1).size() - 1; j++){
                    //add the upper subList's two integers
                    subList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j + 1));
                }
                // the most right one is always 1
                subList.add(1);
            }
            list.add(subList);
        }
        return list;
    }
}