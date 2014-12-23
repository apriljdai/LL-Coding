public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0)
            return result;
        result.add(1);
        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j > 0; j--){
                //.set(int index, e element)
                //Replaces the element at the specified position in this list with the specified element.
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }
}