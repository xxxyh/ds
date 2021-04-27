package leetcode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        int nodeVal = preOrder[preStart];
        int index = -1;
        for(int i = inStart;i <= inEnd;i++){
            if(inOrder[i] == nodeVal){
                index = i;
            }
        }

        TreeNode node = new TreeNode(nodeVal);
        int left = index - inStart;
        node.left = build(preOrder, preStart + 1, left + preStart, inOrder, inStart, index - 1);
        node.right = build(preOrder, left + preStart + 1, preEnd, inOrder, index + 1, inEnd);
        return node;
    }
}
