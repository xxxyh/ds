package leetcode;

import java.util.Stack;

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i = 0;i < S.length();i++){
            char c = S.charAt(i);
            if(c == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }else{
                s1.push(c);
            }
        }
        for(int i = 0;i < T.length();i++){
            char c = T.charAt(i);
            if(c == '#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }else{
                s2.push(c);
            }
        }
        if(s1.size() != s2.size()){
            return false;
        }
        while(!s1.isEmpty()){
            if(s1.pop() != s2.pop()){
                return false;
            }
        }
        return true;
    }
}
