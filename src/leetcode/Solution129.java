package leetcode;

public class Solution129 {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int cur){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            cur = cur * 10 + node.val;
            res += cur;
            return;
        }
        cur = cur * 10 + node.val;
        dfs(node.left, cur);
        dfs(node.right, cur);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.right = right;
        node.left = left;
        new Solution129().sumNumbers(node);
    }
}
