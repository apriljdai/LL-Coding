/*
 Valic Parentheses
 
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put('(', ')');
        hm.put('[', ']');
        hm.put('{', '}');
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++){
            if (hm.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else if (!stack.isEmpty() && hm.get(stack.peek()) == s.charAt(i))
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
}