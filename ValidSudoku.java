public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //test whether each row is valid or not
        for (int i = 0; i < board.length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.' && !test.add(board[i][j]))
                    //Adds the specified element to this set if it is not already present.return boolean
                    //could not use contains, which could just check if it is already present, but could not add into it
                    return false;
            }
        }
        //test whether each column is valid or not
        for (int i = 0; i < board[0].length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for (int j = 0; j < board.length; j++){
                if (board[j][i] != '.' && !test.add(board[j][i]))
                    return false;
            }
        }
        //test whether each block is valid or not
        for (int i = 0; i < 3; i ++){//could not use i += 3
            for (int j = 0; j < 3; j ++){
                HashSet<Character> test = new HashSet<Character>();
                for (int k = i * 3; k < i * 3 + 3; k++){
                    for (int l = j * 3; l < j * 3 + 3; l++){
                        if (board[k][l] != '.' && !test.add(board[k][l]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}