public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1)
            return;
        for (int i = num.length - 2; i >= 0; i--){
            if (num[i] < num[i + 1]){
                int j;
                for (j = num.length - 1; j >= i + 1; j--){
                    if (num[i] < num[j])
                        break;
                }
                //swap two integers in binary, using XOR
                num[i] = num[i] ^ num[j];
                num[j] = num[i] ^ num[j];
                num[i] = num[i] ^ num[j];
                Arrays.sort(num, i + 1, num.length);//Sorts the specified range of the array into ascending order.(int fromIndex, int toIndex)
                return;
            }
        }
        for (int i = 0; i < num.length / 2; i++){
            int temp = num[i];
            num[i] = num[num.length - i - 1];
            num[num.length - i - 1] = temp;
        }
        return;
    }
}