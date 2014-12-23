public class Solution {
    public int numTrees(int n) {
        int unique = 1;
        for (int i = 1; i <= n; i++){
            if (n == 1|| n == 0)
                unique = 1;
            else{
                unique = 2 * (2 * i - 1) * unique / (i + 1);
                //Catalan number algorithm. c = (2n)!/((n+1)!n!)
                //Application:
                    // # of different n binary search tree
                    // # of different paths to n * n square
                    //# of triangle in n+2 polygon
            }
        }
        return unique;
    }
}