package jianzhioffer;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSame(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){//B不为null
            return false;
        }

        return A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}
