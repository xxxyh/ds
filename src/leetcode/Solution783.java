package leetcode;

public class Solution783 {
    int prev = -1;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
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
            min = Math.min(min, cur);
            prev = root.val;
        }

        traversal(root.right);
    }
}
