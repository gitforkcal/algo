package com.test.algo.tree;

import java.util.Stack;

/**
 * @author Rahul
 */
public class IterativePreorder {

    public static void iterativePreorder(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData()+",");
            if(node.getRight() != null)
                stack.push(node.getRight());

            if(node.getLeft()!=null)
                stack.push(node.getLeft());
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);

        iterativePreorder(root);

    }
}
