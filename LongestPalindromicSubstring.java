public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;
        String maxLen = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++){
            //the case that the string is palindrome with i
            String temp = longestPalindrome(s, i, i);
            if (temp.length() > maxLen.length())
                maxLen = temp;
            //the case that the string is palindrome with i & i + 1
            temp = longestPalindrome(s, i, i + 1);
            if (temp.length() > maxLen.length())
                maxLen = temp;
        }
        return maxLen;
    }
    public String longestPalindrome(String s, int begin, int end){
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}