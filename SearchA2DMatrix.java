public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end){
            int middle = (start + end) / 2;
            //find the position of middle in the matrix
            int midRow = middle / matrix[0].length;
            int midCol = middle % matrix[0].length;
            //check if the target is less / equal / larger to middle
            if (matrix[midRow][midCol] == target)
                return true;
            else if (matrix[midRow][midCol] < target)
                start = middle + 1;
            else
                end = middle - 1;
        }
        //if there is no target value in the matrix, return false
        return false;
    }
}