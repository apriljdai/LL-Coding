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