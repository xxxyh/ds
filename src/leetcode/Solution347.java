package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue((o1, o2) -> map.get(o2) - map.get(o1));
        for(int num : nums){
            queue.offer(num);
        }
        int[] res = new int[k];
        int i = 0;
        Set<Integer> used = new HashSet<>();
        while(i < k && !queue.isEmpty()){
            int c = queue.poll();
            if(used.contains(c)){
                continue;
            }
            res[i++] = c;
            used.add(c);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution347().topKFrequent(new int[]{1, 2}, 2));
    }
}
