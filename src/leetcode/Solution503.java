package leetcode;

import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();//栈从下到上递减
        for(int i = 2 * n - 1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            res[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution503().nextGreaterElements(new int[]{1,2,1});
    }
}
