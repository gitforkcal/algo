package com.test.algo.tree;

/**
 * @author Rahul
 */
public class TreeUsingInOrderPreOrder {

    private static TreeNode createTree(int[] inOrder, int[] preOrder) {
        int length = inOrder.length;
        if(length == 0) {
            return null;
        }

        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);

        if(length == 1) {
            return root;
        }

        int indexOfRoot = getIndex(inOrder , rootVal);
        int leftSize = indexOfRoot;
        int rightSize = length - leftSize - 1;

        int [] leftInOrder = new int[leftSize];
        int [] leftPreOrder = new int[leftSize];

        int [] rightInOrder = new int[rightSize];
        int [] rightPreOrder = new int[rightSize];

        System.arraycopy(inOrder,0,leftInOrder,0,leftSize);
        System.arraycopy(inOrder,leftSize+1,rightInOrder,0,rightSize);

        System.arraycopy(preOrder,1,leftPreOrder,0,leftSize);
        System.arraycopy(preOrder,(1+leftSize),rightPreOrder,0,rightSize);

        root.setLeft(createTree(leftInOrder,leftPreOrder));
        root.setRight(createTree(rightInOrder,rightPreOrder));
        return root;
    }

    public static void main(String [] argv) {
        int [] inOrder = {1,2,3,5,7,8};
        int [] preOrder = {5,2,1,3,8,7};

        TreeNode root = createTree(inOrder,preOrder);
        TreeUtility.inOrder(root);
    }

    public static int getIndex(int [] data , int val) {
        for(int i = 0 ; i < data.length ; i++) {
            if(data[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
