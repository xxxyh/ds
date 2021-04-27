package leetcode;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            c2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
