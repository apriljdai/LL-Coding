public class Solution {
    public int numTrees(int n) {
        int num = 1;
        if (n == 1 || n == 0)
            num = 1;
        for (int i = 2; i <= n; i++){
            num = 2 * (2 * i - 1) * num / (i + 1);
        }
        return num;
    }
}
//Catalan number algorithm. c = (2n)!/((n+1)!n!)
//Application:
// # of different n binary search tree
// # of different paths to n * n square
//# of triangle in n+2 polygon
