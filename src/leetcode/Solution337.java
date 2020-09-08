package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
      Map<TreeNode, Integer> dp = new HashMap<>();
      return execute(root, dp);
    }
    private int execute(TreeNode node, Map<TreeNode, Integer> dp){
      if(node == null){
        return 0;
      }
      if(dp.containsKey(node)){
        return dp.get(node);
      }
      int left = val(node);
      if(node.left != null){
        left += execute(node.left.left, dp) + execute(node.left.right, dp);
      }
      if(node.right != null){
        left += execute(node.right.left, dp) + execute(node.right.right, dp);
      }

      int right = execute(node.left, dp) + execute(node.right, dp);
      int result = Math.max(left, right);
      dp.put(node, result);
      return result;
    }
    private int val(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
