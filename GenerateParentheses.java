public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> set = new ArrayList<String>();
        generateParenthesis(n, 0, 0, "", set);
        return set;
    }
    public void generateParenthesis(int n, int left, int right, String s, ArrayList<String> set){
        //the left parenthesis has to be large or equal to the right
        if (left < right)
            return;
        //return set when left and right equal to n
        if (left == n && right == n){
            set.add(s);
            return;
        }
        //when the left equals to n, then only add right
        if (left == n){
            generateParenthesis(n,left, right + 1, s + ")", set);
            return;
            //have to return, or it will continue running 
        }
        generateParenthesis(n, left + 1, right, s + "(", set);
        generateParenthesis(n, left, right + 1, s + ")", set);
    }
}