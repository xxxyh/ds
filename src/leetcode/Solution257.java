package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return result;
        }
        dfs(root, new StringBuilder().append(root.val));
        return result;
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right == null){
            if(sb.length() != 0){
                result.add(sb.toString());
            }
            return;
        }
        if(root.left != null){
            int start = sb.length();
            sb.append("->").append(root.left.val);
            dfs(root.left, sb);
            sb.delete(start, sb.length());
        }
        if(root.right != null){
            int start = sb.length();
            sb.append("->").append(root.right.val);
            dfs(root.right, sb);
            sb.delete(start, sb.length());
        }
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new Solution257().new TreeNode(1);
        TreeNode node2 = new Solution257().new TreeNode(2);
        TreeNode node3 = new Solution257().new TreeNode(3);
        TreeNode node5 = new Solution257().new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        System.out.println(new Solution257().binaryTreePaths(node1));
    }
}
