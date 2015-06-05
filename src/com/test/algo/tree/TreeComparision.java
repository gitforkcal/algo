package com.test.algo.tree;

/**
 * @author Rahul Bhattacharjee
 */
public class TreeComparision {

     public static void main(String [] argv) {
         int [] big = {10,5,20,15,25,24,26};
         int [] small = {25,24,268};

         TreeNode bigTree = TreeUtility.createTree(big);
         TreeNode smallTree = TreeUtility.createTree(small);

         //System.out.println(compare(bigTree,smallTree));
         System.out.println(compare(bigTree,bigTree));
     }

    private static boolean compare(TreeNode bigTree, TreeNode smallTree) {
        if(bigTree == null && smallTree == null){
            return true;
        }
        if(bigTree == null || smallTree == null) {
            return false;
        }
        if(bigTree.getData() == smallTree.getData()) {
            if(compare(bigTree.getLeft(), smallTree.getLeft()) && compare(bigTree.getRight(), smallTree.getRight())) {
                return true;
            }
        }
        if(compare(bigTree.getLeft(), smallTree) || compare(bigTree.getRight(), smallTree)) {
            return true;
        }
        return false;
    }
}
