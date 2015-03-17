public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++){
            int j = i + 1;
            int k = num.length - 1;
            while (j < k){
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum - target);
                if (diff <= min){
                    min = diff;
                    result = sum;
                }
                //could not write as:
                //min = Math.min(min, diff);
                //result = sum;
                //since the result could only equals to sum if diff is smaller than min
                if (sum <= target)
                    j ++;
                else
                    k --;
            }
        }
        return result;
    }
}