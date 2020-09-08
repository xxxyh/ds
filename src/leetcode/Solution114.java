package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        orderFlatten(root);
        root = list.get(0);
    }
    public void orderFlatten(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = new TreeNode(root.val, null, null);
        list.add(node);
        orderFlatten(root.left);
        orderFlatten(root.right);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}