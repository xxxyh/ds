package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            String str = strs[i];
            int[] nums = new int[26];
            for(int j = 0;j < str.length();j++){
                nums[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0;k < 26;k++){
                if(nums[k] != 0){
                    sb.append('a' + k).append(nums[k]);
                }
            }
            String cur= sb.toString();
            if(map.containsKey(cur)){
                res.get(map.get(cur)).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(cur, res.size());
                res.add(list);
            }
        }
        return res;
    }
}
