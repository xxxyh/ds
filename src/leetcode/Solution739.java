package leetcode;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            while(!stack.empty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
