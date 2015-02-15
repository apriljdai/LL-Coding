/*
 String to Integer (atoi)
 
 Implement atoi to convert a string to an integer.
 
 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 
 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */

public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        
        str = str.trim();
        
        int i = 0;
        char flag = '+';
        if (str.charAt(0) == '-'){
            flag = '-';
            i++;
        }
        else if (str.charAt(0) == '+')
            i++;
        
        int res = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if ((Integer.MAX_VALUE / 10 < res) || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < str.charAt(i) - '0')){
                return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }
        return flag == '-' ? -res : res;
        
    }
}