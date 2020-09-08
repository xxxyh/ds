package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        if(time == null || time.length < 2){
            return count;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < time.length;i++){
            int current = time[i] % 60;
            if(map.containsKey(current)){
                count += map.get(current);
            }
            map.put((60 - current) % 60, map.getOrDefault((60 - current) % 60, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1010().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
