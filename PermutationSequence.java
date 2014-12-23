public class Solution {
    public String getPermutation(int n, int k) {
        //the total number of sequence for n is n * (n - 1)!
        ArrayList<Integer> num = new ArrayList<Integer>();
        int sum = 1;
        for (int i = 1; i <= n; i++){
            num.add(i);
            sum *= i;
        }
        sum /= n;
        k--;
        StringBuffer temp = new StringBuffer();
        for (int i = 1; i <= n; i++){
            //use step to know the specific group that k is located
            int step = k / sum;
            temp.append(num.get(step));//Returns the element at the specified position in this list.
            num.remove(num.get(step));
            if (i == n)
                break;
            k %= sum;
            sum /= (n - i);
        }
        return temp.toString();
    }
}