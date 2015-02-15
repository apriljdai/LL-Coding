/*
 Palindrome Number
 
 Determine whether an integer is a palindrome. Do this without extra space.
 
 Could negative integers be palindromes? (ie, -1)
 
 If you are thinking of converting the integer to string, note the restriction of using extra space.
 
 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 
 There is a more generic way of solving this problem.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int diverg = 1;
        while (x / diverg >= 10){
            diverg *= 10;
        }
        while(x > 0){
            int left = x / diverg;
            int right = x % 10;
            if (left != right)
                return false;
            x = (x % diverg) / 10;
            //x lost two digits, so diverg need to divide 100
            diverg = diverg / 100;
        }
        return true;
    }
}