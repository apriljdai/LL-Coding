public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxV = Integer.MIN_VALUE;
        while (start < end){
            //the volumn is the less value times the distance
            int volumn = Math.min(height[start], height[end]) * (end - start);
            maxV = Math.max(maxV, volumn);
            if (height[start] < height[end])
                start ++;
            else
                end --;
        }
        return maxV;
    }
}