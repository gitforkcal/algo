package com.test.algo.tree;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class ArrayTree {

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};

        int [] tree = buildTree(data);
        print(tree);
        inorderTraversal(tree,0);
    }

    public static void print(int [] data) {
        System.out.println(Arrays.toString(data));
    }

    private static void inorderTraversal(int[] tree, int index) {
        if(tree[index] == -1){
            return;
        }
        if(((2*index)+1) < tree.length) {
            inorderTraversal(tree, ((2*index)+1));
        }
        System.out.print(tree[index] +",");
        if(((2*index)+2) < tree.length) {
            inorderTraversal(tree, (2*index)+2);
        }
    }

    private static int[] buildTree(int[] data) {
        int [] tree = new int[data.length*2];
        for(int i = 0 ; i < tree.length ; i++) {
             tree[i] = -1; // -1 is NULL.
        }
        for(int i = 0 ; i < data.length; i++) {
            int val = data[i];
            insert(tree,0,val);
        }
        return tree;
    }

    private static void insert(int[] tree,int start , int val) {
        int currentVal = tree[start];
        if(currentVal == -1){
            tree[start] = val;
        } else if(val < currentVal) {
            insert(tree,((2*start)+1),val);
        } else {
            insert(tree,((2*start)+2),val);
        }
    }
}
