package com.test.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul
 */
public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getData()+",");
            if(node.getLeft() != null){
                queue.offer(node.getLeft());
            }
            if(node.getRight()!= null){
                queue.offer(node.getRight());
            }
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);

        levelOrderTraversal(root);

    }

}
