package ds.binary;

import leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

public class PreOrderTraversal extends BinaryTreeTraversal {

    @Override
    public List<Integer> traversal(){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PreOrderTraversal().traversal());
    }
}
