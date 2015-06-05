package com.test.algo.tree;

/**
 * @author Rahul Bhattacharjee
 */
public class TreeUtility {

    public static boolean isLeaf(TreeNode node) {
        if(node.getLeft() == null && node.getRight() == null){
            return true;
        }
        return false;
    }

    public static TreeNode createTree(int [] data) {
        TreeNode root = new TreeNode();
        root.setData(data[0]);
        for(int i = 1 ; i < data.length ; i++) {
            createNode(root, data[i]);
        }
        return root;
    }

    private static void createNode(TreeNode node , int data) {
        if(data < node.getData()) {
            if(node.getLeft() != null){
                createNode(node.getLeft(), data);
            }else{
                TreeNode newNode = new TreeNode();
                newNode.setData(data);
                node.setLeft(newNode);
            }
        }else{
            if(node.getRight() != null){
                createNode(node.getRight(), data);
            }else{
                TreeNode newNode = new TreeNode();
                newNode.setData(data);
                node.setRight(newNode);
            }
        }
    }

    public static void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.print(node.getData()+",");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public static void inOrder(TreeNode node) {
        if(node == null)
            return;

        inOrder(node.getLeft());
        System.out.print(node.getData()+",");
        inOrder(node.getRight());
    }

    public static boolean isEqual(TreeNode first , TreeNode second) {
        if(first == null && second == null){
            return true;
        }
        if(first != null && second == null){
            return false;
        }
        if(first == null && second != null) {
            return false;
        }
        if(first.getData() != second.getData()) {
            return false;
        }

        boolean leftTree = isEqual(first.getLeft(), second.getLeft());
        boolean rightTree = isEqual(first.getRight(), second.getRight());

        if(leftTree == rightTree == true) {
            return true;
        }
        return false;
    }

    public static boolean isSubTree(TreeNode big , TreeNode small) {
        boolean isSubTree = isEqual(big,small);

        if(isSubTree == false) {
            if(big.getLeft() != null) {
                isSubTree = isEqual(big.getLeft(), small);
                if(isSubTree) {
                    return true;
                }
            }

            if(big.getRight() != null) {
                isSubTree = isEqual(big.getRight(), small);
                if(isSubTree) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = createTree(data);
        preOrder(root);
        System.out.println("==");
        inOrder(root);

        int [] sub = {1,2,3};
        TreeNode subTree = createTree(sub);

        //System.out.println("isEqual => " + isEqual(root,root));

        System.out.println("Sub tree ? => " + isSubTree(root,subTree));
    }
}
