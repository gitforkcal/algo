package com.test.algo.tree;

/**
 * @author Rahul Bhattahcjaree
 */
public class TreeAllAvailablePaths {

    public static void main(String [] argv) {
        int [] data = {10,5,20,15,25,24,26};
        TreeNode root = TreeUtility.createTree(data);
        allPossiblePaths(root);
    }

    private static void allPossiblePaths(TreeNode root) {
        int [] data = new int[100];
        paths(root,data,0);
    }

    private static void paths(TreeNode node,int [] data ,int count) {
        if(node.getLeft() == null && node.getRight() == null) {
            data[count] = node.getData();
            print(data,count+1);
            return;
        }
        data[count] = node.getData();
        paths(node.getLeft(), data, count+1);
        paths(node.getRight(), data, count+1);
    }

    private static void print(int[] data,int count) {
        for(int i = 0 ; i <count;i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
