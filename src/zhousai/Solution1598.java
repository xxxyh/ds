package zhousai;

import leetcode.Solution;

import java.util.Stack;

public class Solution1598 {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String log : logs){
            if(log.equals("../")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(log.equals("./")){
                continue;
            }else{
                stack.push(log);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1598().minOperations(new String[]{"./","../","./"}));
    }
}
