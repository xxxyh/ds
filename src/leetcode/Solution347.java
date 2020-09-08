package leetcode;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue(Comparator.comparingInt(map::get));
        for(int num : nums){
            queue.offer(num);
        }
        int[] res = new int[k];
        int i = 0;
        while(i < k && !queue.isEmpty()){
            res[i++] = queue.poll();
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution347().topKFrequent(new int[]{1, 2}, 2));
    }
}
