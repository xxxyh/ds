package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] splits = s.split(" ");
        if(pattern.length() != splits.length){
            return false;
        }
        Map<String, Character> scMap = new HashMap<>();
        Map<Character, String> csMap = new HashMap<>();
        for(int i = 0;i < pattern.length();i++){
            char c = pattern.charAt(i);
            String str = splits[i];
            if(scMap.containsKey(str)){
                if(scMap.get(str) != c){
                    return false;
                }
            }else{
                scMap.put(str, c);
            }
            if(csMap.containsKey(c)){
                if(!csMap.get(c).equals(str)){
                    return false;
                }
            }else{
                csMap.put(c, str);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution290().wordPattern("aaaa", "dog cat cat dog"));
    }
}
