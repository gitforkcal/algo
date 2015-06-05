package com.test.algo.tree;

/**
 * @author Rahul
 */
public class SumOfBranch {

    private static boolean isBranchPresent(TreeNode root, int sum) {
        return propagate(root,0,sum);
    }

    private static boolean propagate(TreeNode node, int sumTillNow , int sum) {
        sumTillNow = sumTillNow + node.getData();

        if(TreeUtility.isLeaf(node)) {
            if(sumTillNow == sum) {
                return true;
            }
            return false;
        }

        boolean leftPresent = false;
        boolean rightPresent = false;

        if(node.getLeft() != null) {
            leftPresent = propagate(node.getLeft(), sumTillNow, sum);
        }
        if(node.getRight() != null) {
            rightPresent = propagate(node.getRight(), sumTillNow, sum);
        }
        return leftPresent | rightPresent;
    }

    public static void main(String [] arguments) {
        int [] data = {5,2,8,1,3,9,7,6};
        TreeNode root = TreeUtility.createTree(data);
        TreeUtility.inOrder(root);
        System.out.println(isBranchPresent(root,11));
    }
}
