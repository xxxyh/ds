package jianzhioffer;

public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart >= preOrder.length){
            return null;
        }
        int root = preOrder[preStart];

        int index = -1;
        for(int i = inStart;i <= inEnd;i++){
            if(inOrder[i] == root){
                index = i;
                break;
            }
        }
        if(index == -1){
            return null;
        }
        TreeNode node = new TreeNode(root);
        int len = index - inStart;
        node.left = buildTree(preOrder, preStart + 1, preStart + len, inOrder, inStart, index - 1);
        node.right = buildTree(preOrder, preStart + len + 1, preEnd, inOrder, index + 1, inEnd);
        return node;
    }
}
