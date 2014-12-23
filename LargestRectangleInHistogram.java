public class Solution {
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++){
            if (stack.isEmpty() || height[stack.peek()] < height[i])
                stack.push(i);
            else{
                int start = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        //for the last index case
        while(!stack.isEmpty()){
            int start = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }
}
//runtime: O(N)
//find the height which is smaller than the left one, then calculate the area before this height to find the max area