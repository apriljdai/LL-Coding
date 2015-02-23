/*
 Word Search
 
 Given a 2D board and a word, find if the word exists in the grid.
 
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 
 For example,
 Given board =
 
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        boolean [][] check=new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (exist(board, word, check, 0, row, col))
                    return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word, boolean[][] check, int i, int row, int col){
        if (board[row][col] != word.charAt(i) || check[row][col])
            return false;
        check[row][col] = true;
        if (i == word.length() - 1)
            return true;
        
        if (row - 1 >= 0 && exist(board, word, check, i + 1, row - 1, col))
            return true;
        else if (row + 1 <= board.length - 1 && exist(board, word, check, i + 1, row + 1, col))
            return true;
        else if (col - 1 >= 0 && exist(board, word, check, i + 1, row, col - 1))
            return true;
        else if (col + 1 <= board[0].length - 1 && exist(board, word, check, i + 1, row, col + 1))
            return true;
        else{
            check[row][col] = false;
        }
        return false;
    }
}