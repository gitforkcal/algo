package com.test.algo.tree;

import java.util.Stack;

/**
 * @author Rahul
 */
public class IterativePostOrder {

    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> first = new Stack<TreeNode>();
        Stack<TreeNode> second = new Stack<TreeNode>();

        first.push(root);

        while(!first.isEmpty()) {
            TreeNode node = first.pop();
            second.push(node);
            if(node.getLeft()!=null)
                first.push(node.getLeft());
            if(node.getRight()!= null)
                first.push(node.getRight());
        }
        printStack(second);
    }

    public static void printStack(Stack<TreeNode> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().getData() +",");
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);

        postOrderTraversal(root);
    }

}
