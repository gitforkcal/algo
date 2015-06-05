package com.test.algo.tree;

import java.util.Iterator;
import java.util.Stack;

public class IterativeInorder {

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);

        Iterator<TreeNode> iterator = new InorderIterator(root,true);
        while(iterator.hasNext()){
            TreeNode node = iterator.next();
            System.out.print(node.getData());
        }

        sum(root,234);

    }

    private static void sum(TreeNode root, int sum  ) {
        Iterator<TreeNode> lToRIterator = new InorderIterator(root,true);
        Iterator<TreeNode> rToLIterator = new InorderIterator(root,false);

        if(lToRIterator.hasNext() && rToLIterator.hasNext()) {
            int first = lToRIterator.next().getData();
            int second = rToLIterator.next().getData();
            boolean done = false;

            while(!done) {
                int currentSum = first+second;
                if(currentSum == sum) {
                    System.out.println("True");
                    done = true;
                    System.exit(1);
                } else {
                    if(currentSum > sum) {
                        if(rToLIterator.hasNext()) {
                            second = rToLIterator.next().getData();
                        } else {
                            done = true;
                        }
                    } else {
                        if(rToLIterator.hasNext()) {
                            first = rToLIterator.next().getData();
                        } else {
                            done = true;
                        }
                    }
                }
            }
            System.out.print("False");
        }

    }

    private static void reserseInorder(TreeNode root) {
        TreeNode current = root;
        boolean done = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!done) {
            if(current != null) {
                stack.push(current);
                //current = current.getLeft();
                current = current.getRight();
            } else {
                if(stack.isEmpty()) {
                    done = true;
                } else {
                    TreeNode newNode = stack.pop();
                    System.out.print(newNode.getData());
                    //current = newNode.getRight();
                    current = newNode.getLeft();
                }
            }
        }
    }

    private static void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.getLeft());
        System.out.print(root.getData());
        inorder(root.getRight());
    }

    private static void iterativeInorderTraversal(TreeNode root) {
        TreeNode current = root;
        boolean done = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!done) {
            if(current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if(stack.isEmpty()) {
                    done = true;
                } else {
                    TreeNode newNode = stack.pop();
                    System.out.print(newNode.getData());
                    current = newNode.getRight();
                }
            }
        }
    }

    private static class InorderIterator implements Iterator<TreeNode> {

        private TreeNode root;
        private TreeNode current;
        private TreeNode savePoint;
        private boolean lToR;
        private Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        private InorderIterator(TreeNode node,boolean lToR) {
            this.root = node;
            this.current = this.root;
            this.lToR = lToR;
        }

        @Override
        public boolean hasNext() {
            fetchNext();
            return savePoint != null;
        }

        private void fetchNext() {
            boolean done = false;
            while(done == false) {
                if(current != null) {
                   nodeStack.push(current);
                   if(lToR) {
                    current = current.getLeft();
                   }else{
                    current = current.getRight();
                   }
                } else {
                    if(nodeStack.isEmpty()) {
                        savePoint = null;
                        break;
                    } else {
                        savePoint = nodeStack.pop();
                        if(lToR){
                            current = savePoint.getRight();
                        } else {
                            current = savePoint.getLeft();
                        }
                        break;
                    }
                }
            }
        }

        @Override
        public TreeNode next() {
            return savePoint;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported.");
        }
    }
}
