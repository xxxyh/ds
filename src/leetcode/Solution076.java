package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution076 {
    public String minWindow(String s, String t) {
        int n = s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i = 0;i < t.length();i++){
            char c = t.charAt(i);
            pMap.put(c, tMap.getOrDefault(c ,0) + 1);
            tMap.put(c, tMap.getOrDefault(c ,0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int resLeft = -1;
        int i = 0;
        for(;i < n;i++){
            char c = s.charAt(i);
            if(pMap.containsKey(c)){
                pMap.put(c, pMap.get(c) - 1);
                if(pMap.get(c) == 0){
                    pMap.remove(c);
                }
            }
            if(tMap.containsKey(c)){
                if(resLeft == -1){
                    resLeft = i;
                }
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            if(pMap.size() == 0){
                break;
            }
        }
        if(resLeft >= 0){
            char leftChar = s.charAt(resLeft);
            while(!tMap.containsKey(leftChar) || sMap.get(leftChar) > tMap.get(leftChar)){
                if(sMap.containsKey(leftChar)){
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                }
                resLeft++;
                leftChar = s.charAt(resLeft);
            }
        }
        int resRight = i;
        int len = resRight - resLeft + 1;
        int right = i + 1;
        int left = resLeft;

        while(right < n){
            char c = s.charAt(right);
            if(tMap.containsKey(c)){
                sMap.put(c, sMap.get(c) + 1);
                char cur = s.charAt(left);
                while(!tMap.containsKey(cur) || sMap.get(cur) > tMap.get(cur)){
                    if(sMap.containsKey(cur)){
                        sMap.put(cur, sMap.get(cur) - 1);
                    }
                    left++;
                    cur = s.charAt(left);
                }
                int curLen = right - left + 1;
                if(left < right && curLen < len){
                    resRight = right;
                    resLeft = left;
                    len = curLen;
                }
            }
            right++;
        }
        if(resRight < n){
            return s.substring(resLeft, resRight + 1);
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution076().minWindow("bba", "ab"));
    }
}
