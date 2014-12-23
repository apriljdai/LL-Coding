public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        char[][] letter = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m','n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        ArrayList<String> res = new ArrayList<String>();
        letterCombinations(digits, letter, res, "");
        return res;
    }
    public void letterCombinations(String digits, char[][] letter, ArrayList<String> res, String temp){
        if (digits.length() == 0){
            res.add(temp);
            return;
        }
        for (int i = 0; i < letter[digits.charAt(0) - '0' - 1].length; i++){
            letterCombinations(digits.substring(1), letter, res, temp + letter[digits.charAt(0) - '0' - 1][i]);
        }
    }
}