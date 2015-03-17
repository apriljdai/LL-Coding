public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> subset = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0)
            return subset;
        Arrays.sort(S);//Sorts the specified array into ascending numerical order.
        for (int i = 0; i < S.length; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> a: subset){
                temp.add(new ArrayList<Integer>(a));
            }
            for (ArrayList<Integer> a: temp){
                a.add(S[i]);
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            temp.add(single);
            //could not just add S[i] since S[i] is int, but temp is ArrayList<Integer>
            subset.addAll(temp);
        }
        subset.add(new ArrayList<Integer>());
        return subset;
    }
}