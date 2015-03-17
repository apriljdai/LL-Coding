/*
 Best Time Sell Stock
 
 Say you have an array for which the ith element is the price of a given stock on day i.
 
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        //choose the max value, any number compare to it is smaller
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i: prices){
            min = Math.min(min, i);
            max = Math.max(max, (i - min));
        }
        return max;
    }
}