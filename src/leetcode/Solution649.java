package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution649 {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int r = 0;
        int d = 0;
        int countR = 0;
        int countD = 0;
        for(int i = 0;i < senate.length();i++){
            char c = senate.charAt(i);
            if(c == 'R'){
                countR++;
            }else{
                countD++;
            }
            queue.offer(c);
        }

        if(countD == 0){
            return "Radiant";
        }else if(countR == 0){
            return "Dire";
        }

        while(!queue.isEmpty()){
            char c = queue.poll();
            if(c == 'R'){
                if(r > 0){
                    r--;
                    continue;
                }else{
                    queue.offer(c);
                    d++;
                    countD--;
                }
            }else{
                if(d > 0){
                    d--;
                    continue;
                }else{
                    queue.offer(c);
                    r++;
                    countR--;
                }
            }
            if(countR == 0){
                return "Dire";
            }else if(countD == 0){
                return "Radiant";
            }
        }
        if(countD > countR){
            return "Dire";
        }else{
            return "Radiant";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution649().predictPartyVictory("DDRRR"));
    }
}
