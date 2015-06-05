package com.test.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsNew {

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        allPaths(root);
    }

    private static void allPaths(TreeNode root) {
        printPaths(root,new ArrayList<Integer>(),0);
    }

    private static void printPaths(TreeNode node , List<Integer> data , int index) {
        if(node == null){
            return;
        }
        if(node.getRight() == null && node.getLeft() == null) {
            data.add(index,node.getData());
            print(data,index+1);
            return;
        }
        data.add(index,node.getData());
        printPaths(node.getLeft(),data,index+1);
        printPaths(node.getRight(), data, index+1);
    }

    private static void print(List<Integer> data, int index) {
        for(int i = 0 ; i < index;i++) {
            System.out.print(data.get(i));
        }
        System.out.println();
    }


}
