public class Solution {
    public String addBinary(String a, String b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        else{
            StringBuilder result = new StringBuilder();
            //StringBuilder function; could insert char at any place
            int aLength = a.length() - 1;
            int bLength = b.length() - 1;
            int carry = 0;
            
            while (aLength >= 0 || bLength >= 0 || carry > 0){
                //solve the different length problem, just add 0
                int aNumber = (aLength >= 0) ? a.charAt(aLength--) - '0': 0;
                int bNumber = (bLength >= 0) ? b.charAt(bLength--) - '0': 0;
                int current = (aNumber + bNumber + carry) % 2;
                carry = (aNumber + bNumber + carry)/2;
                result.insert(0, current);
            }
            //convert character sequence into string
            return result.toString();
        }
    }
}