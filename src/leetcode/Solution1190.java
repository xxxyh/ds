package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>(chars.length);
        for(int i = 0;i < chars.length;i++){
            if(chars[i] != ')'){
                stack.push(chars[i]);
            }else{
                while(true){
                    char c = stack.pop();
                    if(c == '('){
                        break;
                    }
                    list.add(c);
                }
                for(int j = 0;j < list.size();j++){
                    stack.push(list.get(j));
                }
                list.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1190().reverseParentheses("(abcd)"));
    }
}
