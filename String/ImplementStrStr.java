public class Solution {
    public String strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (haystackLen == needleLen && haystackLen == 0)
            return "";
        if (needleLen == 0)
            return haystack;
        for (int i = 0; i < haystackLen; i++){
            if (haystackLen - i < needleLen)
                return null;
            int k = i, j = 0;
            while (needle.charAt(j) == haystack.charAt(k) && k < haystackLen && j < needleLen){
                j++;
                k++;
                if (j ==needleLen)
                    return haystack.substring(i);
            }
        }
        return null;
    }
}