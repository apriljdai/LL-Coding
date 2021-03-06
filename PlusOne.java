public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            int answer = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = answer;
            if (carry == 0)
                return digits;
        }
        //if the digits are all 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}