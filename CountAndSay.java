/*
 Count and Say
 
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 
 Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        if (n <= 1)
            return String.valueOf(1);//Returns the string representation of the int argument.
        else
            return helper(countAndSay(n - 1));
    }
    public String helper(String s){
        int count = 1;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        //Constructs a string buffer with no characters in it and an initial capacity of 16 characters.
        while (i < s.length()){
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)){
                count ++;
                j++;
            }
            sb.append(count);//Appends the string representation of the char argument to this sequence.
            sb.append(s.charAt(i));
            i = j;
            count = 1;
        }
        return sb.toString();//Returns a string representing the data in this sequence
    }
}