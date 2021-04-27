package leetcode;

public class Solution387 {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] nums = new int[26];
        for(int i = 0;i < n;i++){
            nums[s.charAt(i) - 'a']++;
        }

        for(int i = 0;i < n;i++){
            if(nums[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
