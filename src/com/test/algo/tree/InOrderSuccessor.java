package com.test.algo.tree;

/**
 * @author Rahul
 */
public class InOrderSuccessor {

    // NOTE : if there is a  right child then find the lowest in the right sub tree.
    // find the parent which is a left child.

    public static int inOrderSuccessor(TreeNode node) {
        // not doing the complete implementation.It would need a tree with
        // reference to parent.
        return node.getData();
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        TreeUtility.inOrder(root);
    }
}
