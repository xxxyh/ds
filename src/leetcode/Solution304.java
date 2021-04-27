package leetcode;

class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        dp = new int[n + 1][m + 1];//这里构造n+1,m+1的数组更简单，不用考虑边界
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{{7,7,0},{-4,-7,7},{-4,0,-2},{-8,-5,6}});
        System.out.println(matrix.sumRegion(1,0,2,2));
        System.out.println(matrix.sumRegion(3,2,3,2));
        System.out.println(matrix.sumRegion(2,1,2,2));
        System.out.println(matrix.sumRegion(0,2,2,2));
        System.out.println(matrix.sumRegion(3,2,3,2));
    }
}
