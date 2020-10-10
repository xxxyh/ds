package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String deadend : deadends){
            dead.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                String current = queue.poll();
                if(dead.contains(current)){
                    continue;
                }
                if(current.equals(target)){//输出结果
                    return step;
                }
                for(int j = 0;j < 4;j++){
                    String up = plusOne(current, j);
                    String down = minusOne(current, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    // 将 s[j] 向上拨动一次
    private static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
