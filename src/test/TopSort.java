package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopSort {
    public List<Integer> topSort(int[] nums, int[][] depends) {
        //记录依赖当前key的num有哪些
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //记录当前key依赖的num数量
        Map<Integer, Integer> freMap = new HashMap<>();
        for (int[] depend : depends) {
            //p依赖q
            int p = depend[0];
            int q = depend[1];
            freMap.put(p, freMap.getOrDefault(p, 0) + 1);
            Set<Integer> set = map.computeIfAbsent(q, k -> new HashSet<>());
            set.add(p);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (freMap.containsKey(num) && freMap.get(num) == 0) {
                queue.offer(num);
                freMap.remove(num);
            }
            if (!freMap.containsKey(num)) {
                queue.offer(num);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            if (map.containsKey(node)) {
                Set<Integer> set = map.get(node);
                for (int num : set) {
                    freMap.put(num, freMap.get(num) - 1);
                    if (freMap.containsKey(num) && freMap.get(num) == 0) {
                        queue.offer(num);
                        freMap.remove(num);
                        set.remove(num);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[][] depends = new int[][]{{1, 3}, {2, 1}, {3, 10}};
        new TopSort().topSort(nums, depends).forEach(System.out::println);
    }
}
