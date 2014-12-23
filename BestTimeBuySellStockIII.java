public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int max = 0;
        maxProfit(prices, left, right);
        for (int i = 0; i < prices.length; i++){
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
    public void maxProfit(int[] prices, int[] left, int[] right){
        //for the left part
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++){
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        //for the right part
        right[prices.length - 1] = 0;
        int max = prices[right.length - 1];
        for (int i = prices.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
    }
}
//找寻一个点i，将原来的price[0..n-1]分割为price[0..i]和price[i..n-1]，分别求两段的最大profit