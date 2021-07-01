package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution09 {
    class CQueue {
        Deque<Integer> in;
        Deque<Integer> out;

        public CQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            int res = -1;
            if(!out.isEmpty()){
                res = out.pop();
            }else{
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
                if(!out.isEmpty()){
                    res = out.pop();
                }
            }
            return res;
        }
    }
}
