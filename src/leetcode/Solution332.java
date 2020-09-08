package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution332 {
    Map<String, List<String>> map = new HashMap<>();
    Set<String> used = new HashSet<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0), value->new ArrayList<>()).add(ticket.get(1));
        }
        for(List<String> list : map.values()){
            list.sort(String::compareTo);
        }
        dfs("JFK", 0, tickets.size());
        return  result;
    }
    private boolean dfs(String current, int index, int size){
        if(index == size){
            result.add(current);
            return true;
        }
        List<String> list = map.get(current);
        if(list == null){
            return false;
        }
        result.add(current);
        for(int i = 0;i < list.size();i++){
            if(used.contains(current + "," + i)){
                continue;
            }
            used.add(current + "," + i);
            boolean complete = dfs(list.get(i), index + 1, size);
            if(complete){
                return true;
            }
            used.remove(current + "," + i);
        }
        result.remove(index);
        return false;
    }

    public static void main(String[] args) {
        List<String> t1 = Arrays.asList("JFK","SFO");
        List<String> t2 = Arrays.asList("JFK","ATL");
        List<String> t3 = Arrays.asList("SFO","ATL");
        List<String> t4 = Arrays.asList("ATL","JFK");
        List<String> t5 = Arrays.asList("ATL","SFO");
        List<List<String>> tickets = Arrays.asList(t1, t2, t3, t4, t5);
        System.out.println(new Solution332().findItinerary(tickets));
    }
}
