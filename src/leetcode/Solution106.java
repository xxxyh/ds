package leetcode;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        if(postStart > postEnd){
            return null;
        }
        int nodeVal = postOrder[postEnd];
        int index = -1;
        for(int k = inStart;k <= inEnd;k++){
            if(inOrder[k] == nodeVal){
                index = k;
            }
        }
        TreeNode node = new TreeNode(nodeVal);
        int right = inEnd - index;
        node.left = build(inOrder, inStart, index - 1, postOrder, postStart, postEnd - right - 1);
        node.right = build(inOrder, index + 1, inEnd, postOrder,  postEnd - right, postEnd - 1);
        return node;
    }
}
