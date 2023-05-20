package com.datastructures.trees.binarytrees;

public class ExecuteTree {

    public static void main(String[] args) {

        int treeData1[] = {14, 2, 10, 3, 8, 12, 15, 5, 6};
        int treeData2[] = {7, 2, 5, 9, 1, 11, 14};

        BinaryTreeOperations operations = new BinaryTreeOperations();

        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode root2 = new BinaryTreeNode();

        /* Creating Binary tree */
        BinaryTreeNode createdTreeRoot1 = operations.createBinaryTree(root1, treeData1);
//        BinaryTreeNode createdTreeRoot2 = operations.createBinaryTree(root2, treeData2);

        /* Searching a element in the binary tree */

        if (operations.findDataInBinaryTree(createdTreeRoot1, 6)) {
            System.out.println("The element is present in the tree");
        } else {
            System.out.println("The element is not present in the tree");
        }

        System.out.println("The height of a binary tree is :::: " + operations.heightOfBinaryTree(root1));
    }
}
