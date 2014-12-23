public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        //second char is not *
        if (p.length() == 1 || p.charAt(1) != '*'){
            if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));//beginIndex
        }
        //second char is *
        else{
            int i = -1;//what is i for?
            //first char is . or equal to s
            while (i < s.length() && (i < 0 || p.charAt(0) == '.'|| p.charAt(0) == s.charAt(i))){
                if (isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
}