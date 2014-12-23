public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int begin = -1;
        int maxLen = 0;
        Stack<Integer> temp = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                temp.push(i);
            else{
                if (temp.isEmpty())
                    begin = i;
                else{
                    temp.pop();
                    if (temp.isEmpty())
                        maxLen = Math.max(maxLen, i - begin);
                    else
                        maxLen = Math.max(maxLen,i - temp.peek());
                    //Looks at the object at the top of this stack without removing it from the stack. similar to pop()
                }
            }
            
        }
        return maxLen;
    }
}