package com.datastructures.linkedlist;

import java.util.Scanner;

public class ExecuteMoreListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length for the linkedlist : ");
        int length = scanner.nextInt();
        Node[] node = new Node[length];
        for (int i = 0; i < length; i++) {
            node[i] = new Node();
        }
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node head = singlyLinkedList.createList(node);
        singlyLinkedList.print(head);

        Node node1 = new Node(10, null);
        Node node2 = new Node(9, node1);
        Node node3 = new Node(8, node2);
        Node head2 = new Node(7, node3);

        Node mergedList = singlyLinkedList.mergeLists(head, head2, null);
        System.out.println("Printing merged list");
        singlyLinkedList.print(mergedList);

        Node node4 = new Node(8, null);
        Node node5 = new Node(2, node4);
        Node node6 = new Node(4, node5);
        Node head3 = new Node(9, node6);

        System.out.println("Printing the sorted list. ");
        Node sortedListHead = singlyLinkedList.sortList_UsingSelectionSort(head3);
        singlyLinkedList.print(sortedListHead);

    }
}
