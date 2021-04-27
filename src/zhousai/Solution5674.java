package zhousai;

public class Solution5674 {
    int n = 0, m = 0;
    public String largestMerge(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        char[] merges = new char[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < n && j < m){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(j);
            if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                merges[index++] = c1;
                i++;
            }else{
                merges[index++] = c2;
                j++;
            }
        }
        if(i < n){
            for(int k = i;k < n;k++){
                merges[index++] = word1.charAt(k);
            }
        }
        if(j < m){
            for(int k = j;k < m;k++){
                merges[index++] = word2.charAt(k);
            }
        }
        return new String(merges);
    }


    public static void main(String[] args) {
        System.out.println(new Solution5674().largestMerge("ddddddddydvdddvvdddf", "yydyyyyyyfyydyyfyyyydfyd"));
    }
}
