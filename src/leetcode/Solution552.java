package leetcode;

public class Solution552 {
/*    int count = 0;
    public int checkRecord(int n) {
        int[][][] dp = new int[1][1][1];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 3;//P or L or A
        }
        checkRecord(n, 0, dp);
        return count;
    }
    public void checkRecord(int n, int index, int[][][] dp){
        if(dp[][] >= 2){
            return;
        }
        if(index == n){
            count++;
            return;
        }
        if(prefix.endsWith("LL")){
            checkRecord(n, index + 1, prefix + "P", aSize);
            checkRecord(n, index + 1, prefix + "A", aSize + 1);
        }else if(prefix.endsWith("L")){
            checkRecord(n, index + 1, prefix + "P", aSize);
            checkRecord(n, index + 1, prefix + "A", aSize + 1);
            checkRecord(n, index + 1, prefix + "L", aSize);
        }else{
            checkRecord(n, index + 1, prefix + "P", aSize);
            checkRecord(n, index + 1, prefix + "A", aSize + 1);
            checkRecord(n, index + 1, prefix + "L", aSize);
        }
    }*/

    public static void main(String[] args) {
        //System.out.println(new Solution552().checkRecord(2));
    }
}
