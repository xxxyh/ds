package leetcode;

import java.util.Stack;

public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int cur = (i - k - 1) * heights[j];
                max = Math.max(cur, max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int cur = (heights.length - k - 1) * heights[j];
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution084().largestRectangleArea(new int[]{4,3,2,5,6}));
    }
}
