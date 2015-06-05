package com.test.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Both using level order traversal and rotation.
 *
 * @author Rahul
 */
public class TreeToLinkedList {

    public static TreeNode transformTreeToList(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode previous = null;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if(current.getRight() != null) {
                queue.offer(current.getRight());
            }
            if(previous!=null) {
                previous.setRight(current);
            }
            current.setLeft(previous);
            previous = current;
        }
        return root;
    }


    // NOTE: if no left then continue as usual.
    // if it has a left child then make this node as the child of the right most node of its left.
    // Could not complete the implementation.
    public static TreeNode rotation(TreeNode node) {
        TreeNode returnNode = null;
        if(node.getLeft() == null) {
            returnNode = node;
        } else {
            TreeNode left = node.getLeft();
            TreeNode right = left.getRight();
            if(right == null) {
                left.setRight(node);
                returnNode = left;
            } else {
                while(right.getRight() != null) {
                    right = right.getRight();
                }
                right.setRight(node);
                returnNode = node.getLeft();
                node.setLeft(null);
            }
        }
        return returnNode;
    }

    public static TreeNode transformTreeToListUsingRecursion(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = transformTreeToListUsingRecursion(root.getLeft());
        TreeNode right = transformTreeToListUsingRecursion(root.getRight());

        if(left != null) {
            while(left.getRight() != null) {
                left = left.getRight();
            }
            left.setRight(root);
        }
        root.setLeft(left);

        if(right != null) {
            while(right.getLeft() != null) {
                right = right.getLeft();
            }
            right.setLeft(root);
        }
        root.setRight(right);
        return root;
    }

    public static TreeNode transformTreeToListUsingRecursionMotherFunction(TreeNode root) {
        TreeNode node = transformTreeToListUsingRecursion(root);
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public static TreeNode transformTreeToListUsingRotation(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode returnNode = null;
        while(root.getLeft() != null) {
            root = rotation(root);
            System.out.print("In order using current state. ");
            TreeUtility.inOrder(root);
            System.out.println();
        }
        returnNode = root;
        transformTreeToListUsingRotation(root.getRight());
        return returnNode;
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        TreeUtility.inOrder(root);

        System.out.println("");

        //Using approach 1.
        //root = transformTreeToList(root);

        //Using approach 2.
        //root = transformTreeToListUsingRotation(root);

        root =  transformTreeToListUsingRecursionMotherFunction(root);

        //TreeUtility.inOrder(root);

        while(root != null) {
            System.out.print(root.getData() + ",");
            root = root.getRight();
        }
    }
}
