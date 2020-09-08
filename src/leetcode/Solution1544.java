package leetcode;

import java.util.Stack;

public class Solution1544 {
    public String makeGood(String s) {
        if(s == null ||s.length() <= 1){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(isUpper(c)){
                if(!stack.isEmpty()){
                    char top = stack.peek();
                    if(isUpper(top)){
                        stack.push(c);
                    }else if(Character.toUpperCase(top) == c){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }else if(isLower(c)){
                if(!stack.isEmpty()){
                    char top = stack.peek();
                    if(isLower(top)){
                        stack.push(c);
                    }else if(Character.toLowerCase(top) == c){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private static boolean isLower(char c){
        return c >= 'a' && c <= 'z';
    }

    private static boolean isUpper(char c){
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        System.out.println(new Solution1544().makeGood("Hvh"));
    }
}
