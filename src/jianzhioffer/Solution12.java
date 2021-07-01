package jianzhioffer;

public class Solution12 {
    int n =0 ;
    int m = 0;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        if(word.length() == 0 || n == 0){
            return true;
        }
        char start = word.charAt(0);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == start){
                    boolean[][] visited = new boolean[n][m];
                    boolean res = dfs(board, word, i, j, 0, visited);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int curIndex, boolean[][] visited){
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || (curIndex < word.length() && board[i][j] != word.charAt(curIndex))){
            return false;
        }
        if(curIndex >= word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        curIndex++;
        boolean res = false;
        res = res || dfs(board, word, i + 1, j, curIndex, visited)
                || dfs(board, word, i - 1, j, curIndex, visited)
                || dfs(board, word, i, j + 1, curIndex, visited)
                || dfs(board, word, i, j - 1, curIndex, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution12().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }
}
