package leetcode;

public class Solution079 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        for(int  i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                boolean flag = dfs(board,i, j, 0, visited, word);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, int[][] visited, String word){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j] == 1){
            return false;
        }
        visited[i][j] = 1;
        boolean flag =  dfs(board, i - 1, j, index + 1, visited, word) || dfs(board, i + 1, j, index + 1, visited, word)
                || dfs(board, i, j - 1, index + 1, visited, word) || dfs(board, i, j + 1, index + 1, visited, word);
        visited[i][j] = 0;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Solution079().exist(board, "ABCB"));
    }
}
