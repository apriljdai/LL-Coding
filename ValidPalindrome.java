/*
 Valid Palindrome
 
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 
 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.
 
 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 
 For the purpose of this problem, we define empty string as valid palindrome.
*/

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
}
//method 2
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (s == null)
            return false;
        if (s.length() == 0)
            return true;
        
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}