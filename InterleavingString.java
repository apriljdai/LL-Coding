/*
 Interleaving String
 
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 
 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",
 
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dynamic programming 2D
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] check = new boolean[s1.length() + 1][s2.length() + 1];
        check[0][0] = true;
        int i = 1;
        while (i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1)){
            check[i][0] = true;
            i ++;
        }
        i = 1;
        while (i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1)){
            check[0][i] = true;
            i ++;
        }
        for (i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && check[i - 1][j])
                    check[i][j] = true;
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && check[i][j - 1])
                    check[i][j] = true;
            }
        }
        return check[s1.length()][s2.length()];
    }
}

//recruision method
/*
 public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length())
        return false;
    return isInterleave(s1, 0, s2, 0, s3, 0);
 }
 public boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3){
    if (i3 == s3.length())
        return true;
    if (i1 == s1.length())
        return s2.substring(i2).equals(s3.substring(i3));
    if (i2 == s2.length())
        return s1.substring(i1).equals(s3.substring(i3));
    if (s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3))
        return isInterleave(s1,i1 + 1, s2, i2, s3, i3 + 1) || isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
    if (s1.charAt(i1) == s3.charAt(i3))
        return isInterleave(s1,i1 + 1, s2, i2, s3, i3 + 1);
    if (s2.charAt(i2) == s3.charAt(i3))
        return isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
    else
        return false;
}