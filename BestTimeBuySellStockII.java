public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null)
            return 0;
        int maxProfit = 0;
        for (int i = 0; i < (prices.length - 1); i++){
            int tempProfit = prices[i + 1] - prices[i];
            if (tempProfit > 0)
                maxProfit += tempProfit;
        }
        return maxProfit;
    }
}