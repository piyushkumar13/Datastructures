package com.datastructures.linkedlist;

import java.util.Scanner;

public class ExecuteList {

    public static void main(String[] args) {

        // creating the linked list
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length for the linkedlist : ");
        int length = scanner.nextInt();
        Node[] node = new Node[length];
        for (int i = 0; i < length; i++) {
            node[i] = new Node();
        }
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node head = singlyLinkedList.createList(node);
        singlyLinkedList.print(head);

        // insertion of the node
        System.out.println("Enter the location after which you want to insert node : ");
        int loc = scanner.nextInt();
        System.out.println("Enter the data : ");
        int data = scanner.nextInt();
        try {
            head = singlyLinkedList.insertNode(loc, head, data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Printing linked list after the insertion of the node : \n");
        singlyLinkedList.print(head);

        // deletion of the node.
        System.out.println("Enter the location of the node which you want to delete : \n");
        loc = scanner.nextInt();
        try {
            head = singlyLinkedList.deleteNode(loc, head);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Printing the linked list after deletion \n");
        singlyLinkedList.print(head);

    }

}
