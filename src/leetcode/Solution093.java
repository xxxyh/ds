package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        restoreIpAddresses("", s, 4, result);
        return result;
    }


    private void restoreIpAddresses(String pre, String current, int num, List<String> result){
        if(num < 0){
            return;
        }
        if(num == 0 && current.length() == 0){
            result.add(pre);
            return;
        }
        if(pre.length() != 0){
            pre = pre + ".";
        }
        if(current.startsWith("0")){
            restoreIpAddresses(pre + current.substring(0, 1), current.substring(1), num - 1, result);
            return;
        }
        if(current.length() >= 1){
            restoreIpAddresses(pre + current.substring(0, 1), current.substring(1), num - 1, result);
        }
        if(current.length() >= 2){
            restoreIpAddresses(pre + current.substring(0, 2), current.substring(2), num - 1, result);
        }
        if(current.length() >= 3 && Integer.valueOf(current.substring(0, 3)) < 256){
            restoreIpAddresses(pre + current.substring(0, 3), current.substring(3), num - 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution093().restoreIpAddresses("010010"));
    }
}
