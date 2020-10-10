package leetcode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode();
        if(t1 != null && t2 != null){
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            root.val = t1.val + t2.val;
            return root;
        }
        if(t1 == null){
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
            root.val = t2.val;
        }else{
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
            root.val = t1.val;
        }
        return root;
    }
}
