package leetcode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }

    private boolean ismirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && ismirror(left.left, right.right) && ismirror(left.right, right.left);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
