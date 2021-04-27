package leetcode;

public class Solution861 {
    public int matrixScore(int[][] A) {
        int res = 0;
        if(A == null || A.length == 0 || A[0].length == 0){
            return res;
        }
        int n = A.length;
        int m = A[0].length;
        for(int i = 0;i < n;i++){//保证第一列全为1
            if(A[i][0] != 1){
                for(int j = 0;j < m;j++){
                    A[i][j] ^= 1;
                }
            }
        }
        for(int j = 1;j < m;j++){//从第二列开始，如果这一列0比1多，就翻转这一列
            int count = 0;//1的数量
            for(int i = 0;i < n;i++){
                if(A[i][j] == 1){
                    count++;
                }
            }
            if(count < n - count){//1的数量少于0
                for(int i = 0;i < n;i++){
                    A[i][j] ^= 1;
                }
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(A[i][j] == 1){
                    res += 1 << (m - j - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution861().matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}});
    }
}
