package com.test.algo.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul
 */
public class PrintAllPathsOfTree {

    public static void printAllPaths(TreeNode node ,List<Integer> buffer) {

        buffer.add(node.getData());

        if(node.getRight() == null && node.getLeft() == null) {
            for(Integer integer : buffer) {
                System.out.print(integer+",");
            }
            System.out.println();
            return;
        }

        if(node.getLeft() != null) {
            printAllPaths(node.getLeft() , buffer);
        }
        removeLast(buffer);
        if(node.getRight() != null) {
            printAllPaths(node.getRight(), buffer);
        }
        removeLast(buffer);
    }

    public static void removeLast(List<Integer> list) {
        int size = list.size();
        if(size > 0){
            size--;
        }
        list.remove(size);
    }

    public static void printTree(TreeNode root , int [] buffer, int level) {
        if(root == null)
            return;

        buffer[level++] = root.getData();

        if(root.getRight() == null && root.getLeft() == null) {
            for(int i = 0 ; i < level ; i++) {
                System.out.print(buffer[i]+",");
            }
            System.out.println();
            return;
        }

        if(root.getLeft() != null)
            printTree(root.getLeft(), buffer, level);
        if(root.getRight() != null)
            printTree(root.getRight(),buffer,level);
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        List<Integer> buffer = new LinkedList<Integer>();
        printAllPaths(root,buffer);
        //int [] buf =  new int[20];
        //printTree(root,buf,0);
    }
}
