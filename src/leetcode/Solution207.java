package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> union = new HashSet<>();
        for(int[] prerequisite : prerequisites){
            int key = prerequisite[0];
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        //假设课程号是从0递增的，要不这里有问题
        for(int i = 0; i < numCourses; i++){
            union.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Integer key : union){
            if(!map.containsKey(key)){
                queue.offer(key);
            }else{
                if(map.get(key) == 0){
                    queue.offer(key);
                }
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            Integer current  = queue.poll();
            count++;
            Set<Integer> set = findDepends(prerequisites, current);
            for(Integer key : set){
                Integer value = map.get(key);
                value--;
                map.put(key, value);
                if(value <= 0){
                    queue.offer(key);
                }
            }
        }
        return count == numCourses;
    }

    //找出依current的节点
    private static Set<Integer> findDepends(int[][] prerequisites, int current){
        Set<Integer> set = new HashSet<>();
        for(int[] prerequisite : prerequisites){
            if(prerequisite[1] == current){
                set.add(prerequisite[0]);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{};
        int numCourses = 1;
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
