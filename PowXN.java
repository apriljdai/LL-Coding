public class Solution {
    public double pow(double x, int n) {
        if (n > 0)
            return power(x, n);
        else
            return 1 / power(x, -n);
    }
    public double power(double x, int n){
        if (n == 0)
            return 1;
        double value = power(x, n / 2);
        if (n % 2 == 0)
            value = value * value;
        else
            value = value * value * x;
        return value;
    }
}//runtime O(logN)
/*
 public class Solution {
    public double pow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        double res = x;
        for (int i = 2; i <= n; i++){
            res = res * x;
        }
        return res;
    }
 }
 //runtime O(N)
 */