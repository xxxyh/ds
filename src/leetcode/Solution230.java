package leetcode;

public class Solution230 {
    int index = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }

    private void traversal(TreeNode node, int k){
        if(node == null){
            return;
        }
        traversal(node.left, k);
        index++;
        if(index == k){
            res = node.val;
            return;
        }
        traversal(node.right, k);
    }
}
