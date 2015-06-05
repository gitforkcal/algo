package com.test.algo.tree;

public class AllPathsTree {

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        allPaths(root);
    }

    private static void allPaths(TreeNode root) {
        printPaths(root,new int[10],0);
    }

    private static void printPaths(TreeNode node , int [] data , int index) {
        if(node == null){
            return;
        }
        if(node.getRight() == null && node.getLeft() == null) {
            data[index] = node.getData();
            print(data,index+1);
            return;
        }
        data[index] = node.getData();
        printPaths(node.getLeft(),data,index+1);
        printPaths(node.getRight(), data, index+1);
    }

    private static void print(int[] data, int index) {
        for(int i = 0; i < index;i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }


}
