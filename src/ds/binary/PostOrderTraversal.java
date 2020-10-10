package ds.binary;

import leetcode.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal extends BinaryTreeTraversal{
    @Override
    public List<Integer> traversal() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if(root.left != null){
                stack.add(root.left);
            }
            if(root.right != null){
                stack.add(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PostOrderTraversal().traversal());
    }
}
