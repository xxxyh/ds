package jianzhioffer;

import java.util.Stack;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution31().validateStackSequences(new int[]{1,2,3,4,5},
                new int[]{4,5,3,2,1}));
    }
}
