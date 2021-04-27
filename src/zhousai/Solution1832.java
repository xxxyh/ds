package zhousai;

public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        if(sentence.length() < 26){
            return false;
        }
        for(int i = 0;i < sentence.length();i++){
            arr[sentence.charAt(i) - 'a']++;
        }
        for(int i = 0;i < 26;i++){
            if(arr[i] == 0){
                return false;
            }
        }
        return true;
    }
}
