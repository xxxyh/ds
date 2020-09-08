package leetcode;

public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor){
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] == newColor || image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
    }
}
