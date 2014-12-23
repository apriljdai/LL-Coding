public class Solution {
    public int atoi(String str) {
        //return 0 if str is empty or just white space
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();//Returns a copy of the string, with leading and trailing whitespace omitted.
        //check the first sign
        char check = '+';
        int i = 0;
        if (str.charAt(0) == '-'){
            check = '-';
            i++;
        }
        if (str.charAt(0) == '+')
            i++;
        double res = 0.0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (check == '-')
            res = - res;
        //deal with the out of the range problem
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) res;
    }
}