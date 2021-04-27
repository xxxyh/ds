package leetcode;

public class Solution1038 {
    int res = 0;
    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode node){
        if(node == null){
            return;
        }
        traversal(node.right);
        node.val = node.val + res;
        res = node.val;
        traversal(node.left);
    }
}
