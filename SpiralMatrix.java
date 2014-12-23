public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiral = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return spiral;
        int row = matrix.length, col = matrix[0].length;
        int x = 0, y = 0;
        while (row > 0 && col > 0){
            if (row == 1){
                for (int i = 0; i < col; i++)
                    spiral.add(matrix[x][y++]);
                break;
            }
            if (col == 1){
                for (int i = 0; i < row; i++)
                    spiral.add(matrix[x++][y]);
                break;
            }
            for (int i = 0; i < col - 1; i++)
                spiral.add(matrix[x][y++]);
            for (int i = 0; i < row - 1; i++)
                spiral.add(matrix[x++][y]);
            for (int i = 0; i < col - 1; i++)
                spiral.add(matrix[x][y--]);
            for (int i = 0; i < row - 1; i++)
                spiral.add(matrix[x--][y]);
            x ++;
            y ++;
            row -= 2;
            col -= 2;
        }
        return spiral;
    }
}