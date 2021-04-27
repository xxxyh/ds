package leetcode;

import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        Stack<Character> cStack = new Stack<>();
        Stack<Character> sStack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                cStack.push(c);
            }else{
                int cur = 0;
                int k = 1;
                while(!cStack.isEmpty()){
                    char top = cStack.pop();
                    cur += (top - '0') * k;
                    k *= 10;
                }
                iStack.push(cur);
            }
        }
        int cur = 0;
        int k = 1;
        while(!cStack.isEmpty()){
            char top = cStack.pop();
            cur += (top - '0') * k;
            k *= 10;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution224().calculate("- (3 + (4 + 5))"));
    }
}
