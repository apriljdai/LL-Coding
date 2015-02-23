/*
 Candy
 
 There are N children standing in a line. Each child is assigned a rating value.
 
 You are giving candies to these children subjected to the following requirements:
 
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int[] comp1 = new int[ratings.length];
        int[] comp2 = new int[ratings.length];
        
        //calculate from left to right
        comp1[0] = 1;
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1])
                comp1[i] = comp1[i - 1] + 1;
            else
                comp1[i] = 1;
        }
        
        //calculate from right to left
        comp2[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1])
                comp2[i] = comp2[i + 1] + 1;
            else
                comp2[i] = 1;
        }
        //get the max value of two arrays
        int[] max = new int[ratings.length];
        int result = 0;
        for (int i = 0; i < ratings.length; i++){
            max[i] = Math.max(comp1[i], comp2[i]);
            result += max[i];
        }
        return result;
    }
}