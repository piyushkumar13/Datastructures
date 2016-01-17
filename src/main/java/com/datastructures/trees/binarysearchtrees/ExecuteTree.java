package com.datastructures.trees.binarysearchtrees;

public class ExecuteTree {

    public static void main(String[] args) {
        BinarySearchTreeOperations operations = new BinarySearchTreeOperations();

        BinarySearchTreeNode root = operations.insertNodeInBinarySearchTree(null, 5);
        operations.insertNodeInBinarySearchTree(root, 3);
        operations.insertNodeInBinarySearchTree(root, 10);
        operations.insertNodeInBinarySearchTree(root, 6);
        operations.insertNodeInBinarySearchTree(root, 1);
        operations.insertNodeInBinarySearchTree(root, 9);
        operations.insertNodeInBinarySearchTree(root, 4);

        /* Printing Binary Search Tree in in-order  */
        System.out.println("The inorder traversal of the BST is : ");
        operations.traverseBSTInOrder(root);

        /* Printing Binary Search Tree in post-order */
        System.out.println("The post-order traversal of the BST is : ");
        operations.traverseBSTInPostOrder(root);

        BinarySearchTreeNode findNode = operations.findElementInBST(root, 7);
        if (findNode == null) {
            System.out.println("Does not contain any node with specified value ");

        } else {
            System.out.println("BST contains the node with the specified value ");
        }

        /* Minimum value node */
        BinarySearchTreeNode minNode = operations.findMinElementInBST(root);
        System.out.println("The minimum value in the BST is " + minNode.getData());

        /* Maximum value node */
        BinarySearchTreeNode maxNode = operations.findMaxElementInBST(root);
        System.out.println("The maximum value in the BST is " + maxNode.getData());
    }
}
