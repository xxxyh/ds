package jianzhioffer;

import java.util.Stack;

public class Solution06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        int n = stack.size();
        int[] res = new int[n];
        int index = 0;
        while(!stack.isEmpty()){
            res[index++] = stack.pop().val;
        }
        return res;
    }

}
