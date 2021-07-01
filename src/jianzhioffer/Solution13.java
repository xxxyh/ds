package jianzhioffer;

public class Solution13 {
    int res = 0;
    public int movingCount(int m, int n, int k) {
        dfs(m, n, 0, 0, k, new boolean[m][n]);
        return res;
    }

    private void dfs(int m, int n,int i, int j, int k, boolean[][] visited){
        if(i >= m || j >= n || i < 0 || j < 0 || (i % 10 + i / 10 + j % 10 + j / 10) > k || visited[i][j]){
            return;
        }
        res++;
        visited[i][j] = true;
        dfs(m, n, i + 1, j, k, visited);
        dfs(m, n, i - 1, j, k, visited);
        dfs(m, n, i, j + 1, k, visited);
        dfs(m, n, i, j - 1, k, visited);
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(3,1,0));
    }
}
