package leetcode;

import java.util.Stack;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for(int i = 0;i < s.length();i++){
            count[s.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            count[c]--;
            if(inStack[c]){
                 continue;
            }
            while(!stack.isEmpty() && c < stack.peek()){
                if(count[stack.peek()] == 0){//
                    break;
                }
                char p = stack.pop();
                inStack[p] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("bcabc"));
    }
}
