public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        //replaceAll:Replaces each substring of this string that matches the given regular expression with the given replacement.
        //a-zA-Z:a through z or A through Z, inclusive (range)
        //^a-zA-Z0-9:exclusive a through z and 0 to 9
        if(s == null)
            return false;
        if (s.length() == 0)
            return true;
        Stack<Character> result = new Stack<Character>();
        int index = 0;
        while (index < s.length() / 2){
            result.push(s.charAt(index));
            index ++;
        }
        if (s.length() % 2 == 1)
            index ++;
        while (index < s.length()){
            if (result.empty())
                return false;
            char temp = result.pop();
            if (temp != s.charAt(index))
                return false;
            else
                index ++;
        }
        return true;
    }
    /*
        if(s == null)
            return false;
        if (s.length() == 0)
            return true;
        s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j){
            while(i < j && !isValid(s.charAt(i)))
                i ++;
            while( i < j && !isValid(s.charAt(j)))
                j --;
            if (s.charAt(i) != s.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
     }
     private boolean isValid(char a){
        if (a >= 'a' && a <= 'z')
            return true;
        if (a >= '0' && a <= '9')
            return true;
        else
            return false;
     }
     */
}