package com.test.algo.tree;

import java.util.Stack;

public class NonRecursiveLeafNodePath {
    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        allPaths(root);
    }

    private static void allPaths(TreeNode root) {
        boolean done = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while(!done) {
            if(current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if(stack.isEmpty()) {
                    done = true;
                } else {
                    printIfLeaf(stack);
                    TreeNode node = stack.pop();
                    current = node.getRight();
                }
            }
        }
    }

    private static void printIfLeaf(Stack<TreeNode> stack) {
        if(stack.peek().getLeft() == null && stack.peek().getRight() == null) {
            Stack<TreeNode> aux = new Stack<TreeNode>();
            while(!stack.isEmpty()) {
                aux.push(stack.pop());
            }
            while(!aux.isEmpty()) {
                TreeNode current = aux.pop();
                System.out.print(current.getData());
                stack.push(current);
            }
            System.out.println();
        }
    }
}
