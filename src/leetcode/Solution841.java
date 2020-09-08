package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return canVisit(rooms, 0, visited);
    }
    public boolean canVisit(List<List<Integer>> rooms, int index, Set<Integer> visited){
        if(visited.size() == rooms.size()){
            return true;
        }
        List<Integer> room = rooms.get(index);
        for(Integer current : room){
            if(visited.contains(current)){
                continue;
            }
            visited.add(current);
            boolean flag = canVisit(rooms, current, visited);
            if(flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 3);
        List<Integer> l2 = Arrays.asList(3,0,1);
        List<Integer> l3 = Arrays.asList(2);
        List<Integer> l4 = Arrays.asList(0);
        List<List<Integer>> list = Arrays.asList(l1, l2, l3, l4);
        System.out.println(new Solution841().canVisitAllRooms(list));
    }
}
