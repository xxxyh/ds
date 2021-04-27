package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int c = nums.length - k;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0;i < nums.length;i++){
            while(!queue.isEmpty() && c > 0 && queue.peekLast() > nums[i]){
                queue.pollLast();
                c--;
            }
            queue.offerLast(nums[i]);
        }
        for(int i = 0;i < k;i++){
            res[i] = queue.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution1673().mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4);
    }
}
