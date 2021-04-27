package leetcode;

import java.util.PriorityQueue;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0;i < stones.length;i++){
            queue.offer(stones[i]);
        }
        while(queue.size() > 1){
            Integer i = queue.poll();
            Integer j = queue.poll();
            if(!i.equals(j)){
                queue.offer(i - j);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
