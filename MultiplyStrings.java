public class Solution {
    public String multiply(String num1, String num2) {
        //reverse the string which easier to calculate
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        //Causes this character sequence to be replaced by the reverse of the sequence
        int[] num = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++){
            for (int j = 0; j < num2.length(); j++){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                num[i + j] += a * b;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length; i++){
            int digit = num[i] % 10;
            int carry = num[i] / 10;
            result.insert(0, digit);//insert(offset, int)在第0位加digit
            //Inserts the string representation of the second int argument into this sequence.
            if (i < num.length - 1)
                num[i + 1] += carry;
        }
        while (result.length() > 0 && result.charAt(0) == '0')
            result.deleteCharAt(0);
        //Removes the char at the specified position in this sequence.
        return result.length() == 0? "0" : result.toString();
    }
}