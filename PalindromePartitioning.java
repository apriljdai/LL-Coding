public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)
            return result;
        ArrayList<String> temp = new ArrayList<String>();
        partition(s, result, temp, 0);
        return result;
    }
    public void partition(String s, ArrayList<ArrayList<String>> result, ArrayList<String> temp, int start){
        if (start == s.length()){
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++){
            String subString = s.substring(start, i);
            if (isPalindrome(subString)){
                temp.add(subString);
                partition(s.substring(i), result, temp, start);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}