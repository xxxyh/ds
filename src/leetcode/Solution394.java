package leetcode;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(']' == c){
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")){
                    sb.insert(0, stack.pop());
                }
                stack.pop();//丢弃"["
                Integer times = Integer.valueOf(stack.pop());
                StringBuilder temp = new StringBuilder();
                while(times-- > 0){
                    temp.append(sb);
                }
                stack.push(temp.toString());
            }else if(c >= '0' && c <= '9'){
                StringBuilder sb = new StringBuilder();
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;//多加了一次，如果只循环一次的话，是不需要++的
                stack.push(sb.toString());
            }else{
                stack.push(s.substring(i ,i + 1));
            }

        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
