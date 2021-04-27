package leetcode;

public class Solution530 {
    int min = Integer.MAX_VALUE;
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);

        if(prev == -1){
            prev = root.val;
        }else{
            int cur = Math.abs(prev - root.val);
            min = Math.min(cur, min);
            prev = root.val;
        }

        traversal(root.right);
    }
}
