public class Solution {
    public int sqrt(int x) {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;
        double result = 0, y = 1;
        //Newton's method: y = y - f(y)/f'(y)
        //f(y) = y * y - x, when f(y) = 0, y = sqrt(x), f'(y) = 2 * y
        while (y != result){
            result = y;
            y = (y + x / y) / 2;
        }
        return (int)y;
    }
}