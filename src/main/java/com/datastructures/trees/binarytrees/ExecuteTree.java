package com.datastructures.trees.binarytrees;

public class ExecuteTree {

    public static void main(String[] args) {

        int treeData1[] = {14, 2, 10, 3, 8, 12, 15};
        int treeData2[] = {7, 2, 5, 9, 1, 11, 14};

        BinaryTreeOperations operations = new BinaryTreeOperations();

        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode root2 = new BinaryTreeNode();

        /* Creating Binary tree */
        BinaryTreeNode createdTreeRoot1 = operations.createBinaryTree(root1, treeData1);
        BinaryTreeNode createdTreeRoot2 = operations.createBinaryTree(root2, treeData2);

        /* Traversing Binary tree in In-order */
        System.out.println("Printing Binary tree 1 in order :::");
        operations.traverseBinaryTreeInOrder(createdTreeRoot1);
        System.out.println("Printing Binary tree 2 in order :::");
        operations.traverseBinaryTreeInOrder(createdTreeRoot2);

        /* Traversing Binary tree in post order */
        System.out.println("Printing Binary tree 1 in post order :::");
        operations.traverseBinaryTreeInPostOrder(createdTreeRoot1);
        System.out.println("Printing Binary tree 2 in post order :::");
        operations.traverseBinaryTreeInPostOrder(createdTreeRoot2);

        /* Level order traversal */
        System.out.println("The level order traversal of Binary tree 1 : ");
        operations.traverseBinaryTreeInLevelOrder(createdTreeRoot1);
        System.out.println("The level order traversal of Binary tree 2 : ");
        operations.traverseBinaryTreeInLevelOrder(createdTreeRoot2);

        /* Checking whether two Binary trees are isomorphic or not */
        if (operations.isIsoMorphic(createdTreeRoot1, createdTreeRoot2)) {
            System.out.println("The two trees are isomorphic");
        }

        /* Size of the binary tree */
        System.out.println("The size of the binary tree is : " + operations.sizeOfBinaryTree(createdTreeRoot1));

        /* Height of the binary tree */
        System.out.println("The height of the binary tree is : " + operations.heightOfBinaryTree(createdTreeRoot1));
    }
}
