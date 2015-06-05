package com.test.algo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rahul
 */
public class SemiBranchSumInTree {

    // Idea is to find all possible branches and semi branches
    // which sum to a particular number of a tree.

    public static void printBranchSum(TreeNode node , List<Integer> buffer , int sum) {
        if(node == null) {
            return;
        }

        buffer.add(node.getData());
        int temp = 0 ;
        int index = 0;
        int [] trail = new int[buffer.size()];

        for(int i = (buffer.size()-1); i >= 0 ;i--) {
            int val = buffer.get(i);
            trail[index++] = val;
            temp += val;
            if(temp == sum) {
                System.out.println("Path " + Arrays.toString(trail));
            }
        }

        List<Integer> left = (List<Integer>) ((ArrayList<Integer>)buffer).clone();
        List<Integer> right = (List<Integer>) ((ArrayList<Integer>)buffer).clone();

        if(node.getRight() != null) {
            printBranchSum(node.getRight() , left, sum);
        }

        if(node.getLeft() != null) {
            printBranchSum(node.getLeft() , right, sum);
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        //TreeUtility.inOrder(root);
        printBranchSum(root,new ArrayList<Integer>(),13);
    }
}
