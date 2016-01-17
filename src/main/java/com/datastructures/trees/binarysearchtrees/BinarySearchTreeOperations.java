package com.datastructures.trees.binarysearchtrees;

public class BinarySearchTreeOperations {

    public BinarySearchTreeNode insertNodeInBinarySearchTree(BinarySearchTreeNode root, int data) {

        if (root == null) {
            root = new BinarySearchTreeNode(data, null, null);

        } else {
            if (data < root.getData()) {
                root.setLeft(insertNodeInBinarySearchTree(root.getLeft(), data));

            } else if (data > root.getData()) {
                root.setRight(insertNodeInBinarySearchTree(root.getRight(), data));
            }
        }
        return root;
    }

    public void traverseBSTInOrder(BinarySearchTreeNode root) {

        if (root != null) {
            traverseBSTInOrder(root.getLeft());
            System.out.println(root.getData());
            traverseBSTInOrder(root.getRight());
        }
    }

    public void traverseBSTInPostOrder(BinarySearchTreeNode root) {
        if (root != null) {
            traverseBSTInPostOrder(root.getLeft());
            traverseBSTInPostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public BinarySearchTreeNode findElementInBST(BinarySearchTreeNode root, int data) {
        if (root == null) {
            return null;

        } else if (data < root.getData()) {
            return findElementInBST(root.getLeft(), data);

        } else if (data > root.getData()) {
            return findElementInBST(root.getRight(), data);
        }
        return root;
    }

    public BinarySearchTreeNode findMinElementInBST(BinarySearchTreeNode root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public BinarySearchTreeNode findMaxElementInBST(BinarySearchTreeNode root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }
}
