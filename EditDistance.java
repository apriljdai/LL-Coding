public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] temp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++){
            temp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++){
            temp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++){
            char letter1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++){
                char letter2 = word2.charAt(j - 1);
                if (letter1 == letter2)
                    temp[i][j] = temp[i - 1][j - 1];
                else{
                    //temp[i - 1][j - 1] is the replace spot
                    int replace = temp[i - 1][j - 1] + 1;
                    //temp[i][j - 1] is the delete spot
                    int delete = temp[i][j - 1] + 1;
                    //temp[i - 1][j] is the insert spot
                    int insert = temp[i - 1][j] + 1;
                    temp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return temp[word1.length()][word2.length()];
    }
}