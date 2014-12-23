public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0)
            return "";
        if (nRows == 1)
            return s;
        StringBuilder result = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++){
            for (int j = i; j < s.length(); j += size){
                result.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + size -i * 2< s.length())
                    result.append(s.charAt(j + size - 2 *i));
            }
        }
        return result.toString();//stringBuilder, not string
    }
}