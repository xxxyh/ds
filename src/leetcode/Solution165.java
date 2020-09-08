package leetcode;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] splits1 = version1.split("\\.");
        String[] splits2 = version2.split("\\.");
        int min = Math.min(splits1.length, splits2.length);
        for(int i = 0;i < min;i++){
            int c = Integer.valueOf(splits1[i]).compareTo(Integer.valueOf(splits2[i]));
            if(c > 0){
                return 1;
            }else if(c < 0){
               return -1;
            }
        }
        if(splits1.length > min){
            for(int i = min;i < splits1.length;i++){
                if(Integer.valueOf(splits1[i]) > 0){
                    return 1;
                }
            }
            return 0;
        }else if(splits2.length > min){
            for(int i = min;i < splits2.length;i++){
                if(Integer.valueOf(splits2[i]) > 0){
                    return -1;
                }
            }
            return 0;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution165().compareVersion("1", "1.1"));
    }
}
