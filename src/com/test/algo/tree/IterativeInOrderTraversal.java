package com.test.algo.tree;

import java.util.Stack;

/**
 * @author Rahul
 */
public class IterativeInOrderTraversal {

    public static void iterativeInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        boolean done = false;

        while(!done) {
            if(current != null){
                stack.push(current);
                current = current.getLeft();
            } else if(stack.isEmpty()) {
                done = true;
            } else {
                current = stack.pop();
                System.out.print(current.getData()+",");
                current = current.getRight();
            }
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);

        iterativeInorderTraversal(root);
    }
}
