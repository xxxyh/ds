package leetcode;

public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return matrix;
        }
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
