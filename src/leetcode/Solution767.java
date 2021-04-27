package leetcode;

public class Solution767 {
    public String reorganizeString(String S) {
        int len = S.length();
        int[] arr = new int[26];
        for(int i = 0;i < len;i++){
            arr[S.charAt(i) - 'a']++;
        }
        int f;
        if(len % 2 == 0){
            f = len / 2;
        }else{
            f = len / 2 + 1;
        }
        for(int i = 0;i < 26;i++){
            if(arr[i] > f){
                return "";
            }
        }
        char[] chars = new char[len];
        int last = -1;
        for(int i = 0;i < len;i++){
            int max = -1;
            int maxIndex = -1;
            for(int j = 0; j < 26;j++){
                if(arr[j] > max && last != j){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            chars[i] = (char)('a' + maxIndex);
            arr[maxIndex]--;
            last = maxIndex;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution767().reorganizeString("aab"));
    }
}
