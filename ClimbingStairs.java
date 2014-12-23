public class Solution {
    public int climbStairs(int n) {
        int[] way = new int[n + 1];
        way[0] = 1;
        way[1] = 1;
        for (int i = 2; i <= n; i++){
            way[i] = way[i - 1] + way[i - 2];
        }
        return way[n];
    }
}

//too slow to code as recursion
//code as dynamic processing