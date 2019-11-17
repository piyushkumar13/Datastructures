package com.datastructures.trees.binarytrees;

import java.util.LinkedList;

@SuppressWarnings({"ConstantConditions", "UnnecessaryLocalVariable"})
public class BinaryTreeOperations {


    public BinaryTreeNode createBinaryTree(BinaryTreeNode root, int arr[]) {

         /* Following are the leaf nodes */
        BinaryTreeNode nodeTemp1 = new BinaryTreeNode(arr[7], null, null);
        BinaryTreeNode nodeTemp2 = new BinaryTreeNode(arr[8], null, null);

        BinaryTreeNode node1 = new BinaryTreeNode(arr[3], nodeTemp1, nodeTemp2);
        BinaryTreeNode node2 = new BinaryTreeNode(arr[4], null, null);

        BinaryTreeNode node3 = new BinaryTreeNode(arr[1], node1, node2);

        /* Following are the leaf nodes */
        BinaryTreeNode node4 = new BinaryTreeNode(arr[5], null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(arr[6], null, null);

        BinaryTreeNode node6 = new BinaryTreeNode(arr[2], node4, node5);

        root.setData(arr[0]);
        root.setLeft(node3);
        root.setRight(node6);

        return root;
    }

    public void traverseBinaryTreeInOrder(BinaryTreeNode root) {

        if (root != null) {
            traverseBinaryTreeInOrder(root.getLeft());
            System.out.println(root.getData());
            traverseBinaryTreeInOrder(root.getRight());
        }
    }

    public void traverseBinaryTreeInPostOrder(BinaryTreeNode root) {

        if (root != null) {
            traverseBinaryTreeInPostOrder(root.getLeft());
            traverseBinaryTreeInPostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void traverseBinaryTreeInLevelOrder(BinaryTreeNode root) {

        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.removeFirst();
            System.out.println(temp.getData());

            if (temp.getLeft() != null) {
                queue.addLast(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.addLast(temp.getRight());
            }
        }
    }

    public boolean isIsoMorphic(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        boolean leftSubTreeCheck = isIsoMorphic(root1.getLeft(), root2.getLeft());
        boolean rightSubTreeCheck = isIsoMorphic(root1.getRight(), root2.getRight());
        return leftSubTreeCheck && rightSubTreeCheck;
    }

    public int sizeOfBinaryTree(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int tempSize = sizeOfBinaryTree(root.getLeft()) + 1;
            int size = tempSize + sizeOfBinaryTree(root.getRight());
            return size;
        }
    }

    public int heightOfBinaryTree(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int leftSubTreeHeight = heightOfBinaryTree(root.getLeft());
            int rightSubTreeHeight = heightOfBinaryTree(root.getRight());

            if (leftSubTreeHeight > rightSubTreeHeight) {
                return leftSubTreeHeight + 1;
            } else {
                return rightSubTreeHeight + 1;
            }
        }
    }

    public boolean findDataInBinaryTree(BinaryTreeNode root, int data) {

        boolean temp = false;
        if (root == null) {
            return false;
        } else {
            if (data == root.getData()) {
                return true;
            } else {
                temp = findDataInBinaryTree(root.getLeft(), data);
                if (temp) {
                    return true;
                } else {
                    return findDataInBinaryTree(root.getRight(), data);
                }
            }
        }
    }


    public BinaryTreeNode getLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2){

        if (root == n1 || root == n2){
            return root;
        }

        BinaryTreeNode left = getLCA(root.getLeft(), n1, n2);
        BinaryTreeNode right = getLCA(root.getRight(), n1, n2);

        if (left != null && right != null){
            return root;
        }

        return left != null? left : right;
    }

    public int getDiameter(BinaryTreeNode root){
        if (root == null){
            return 0;
        }

        int left = heightOfBinaryTree(root.getLeft());
        int right = heightOfBinaryTree(root.getRight());

        int leftDiameter = getDiameter(root.getLeft());
        int rightDiameter = getDiameter(root.getRight());

        return Math.max(left + right + 1, Math.max(leftDiameter, rightDiameter));
    }
}
