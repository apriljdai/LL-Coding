public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == ' ' && count != 0){
                break;
            }
            //if use count++ instead of stating if statement, there is one situation that string s = " " which will return 1 instead of 0
            if(s.charAt(i) != ' ')
                count ++;
        }
        return count;
    }
}
//cannot use split function since the number of words in s cannot be known
//String[] ss = new String[N];
//N cannot be blanked