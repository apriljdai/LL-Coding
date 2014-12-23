public class Solution {
    public int numDecodings(String s) {
        //1D dynamic programming
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int[] temp = new int[s.length() + 1];
        temp[0] = 1;
        temp[1] = 1;
        int result;
        for (int i = 2; i <= s.length(); i++){
            result = Integer.parseInt(s.substring(i - 1, i));
            //Parses the string argument as a signed decimal integer.
            if (result != 0)
                temp[i] = temp[i - 1];
            if (s.charAt(i - 2) != '0'){
                result = Integer.parseInt(s.substring(i - 2, i));
                if (result >= 1 && result <= 26)
                    temp[i] += temp[i - 2];
            }
        }
        return temp[s.length()];
    }
}