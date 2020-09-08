package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() < p.length()){
            return result;
        }
        int k = p.length();
        //记录每个字符出现的次数
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();
        for(Character c : p.toCharArray()){
            if(pmap.containsKey(c)){
                pmap.put(c, pmap.get(c) + 1);
            }else{
                pmap.put(c, 1);
            }
        }
        for(int i = 0;i < k;i++){
            if(smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i), smap.get(s.charAt(i)) + 1);
            }else{
                smap.put(s.charAt(i), 1);
            }
        }
        if(equals(smap, pmap)){
            result.add(0);
        }
        for(int i = 1;i < s.length() - k + 1;i++){
            smap.put(s.charAt(i - 1), smap.get(s.charAt(i - 1)) - 1);
            if(smap.containsKey(s.charAt(i + k - 1))){
                smap.put(s.charAt(i + k - 1), smap.get(s.charAt(i + k - 1)) + 1);
            }else{
                smap.put(s.charAt(i + k - 1), 1);
            }
            if(equals(smap, pmap)){
                result.add(i);
            }
        }
        return result;
    }
    private boolean equals(Map<Character, Integer> smap, Map<Character, Integer> pmap){
        for(Map.Entry<Character, Integer> entry : pmap.entrySet()){
            if(!entry.getValue().equals(smap.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("cbaebabacd", "abc"));
    }
}
