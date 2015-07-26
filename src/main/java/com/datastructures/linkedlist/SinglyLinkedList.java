package com.datastructures.linkedlist;

public class SinglyLinkedList {

    /**
     * This method creates the linked list.
     */
    Node createList(Node[] node) {
        Node head = node[0];
        int i = 1;
        for (; i < node.length; i++) {
            node[i - 1].setData(i - 1);
            node[i - 1].setNext(node[i]);
        }
        node[i - 1].setData(i - 1);
        return head;
    }

    void print(Node head) {
        int i = 1;
        Node temp = head;
        while (temp != null) {
            System.out.println(String.format("the value of a node %s : ", i) + temp.getData() + "\n");
            temp = temp.getNext();
            i++;
        }
    }

    /**
     * This method inserts the node in the linked list after the defined location.
     */
    Node insertNode(int loc, Node head, int data) {
        Node temp = head;
        if (loc > length(head)) {
            throw new InValidException("Location is out of the scope of the linked list");
        }
        if (loc == 0) { //adding not at the front of the linked list
            Node node = new Node();
            node.setData(data);
            node.setNext(head);
            head = node;
            return head;

        } else { //adding node after the specified location
            int i = 1;
            while (i < loc) {
                temp = temp.getNext();
                i++;
            }
            Node insertNode = new Node();
            insertNode.setData(data);
            insertNode.setNext(temp.getNext());
            temp.setNext(insertNode);
        }
        return head;
    }

    /**
     * This method deletes the node from the defined location in the linked list.
     */
    public Node deleteNode(int loc, Node head) {

        Node temp;
        if (loc == 0 || loc > length(head)) {
            throw new InValidException("Location is out of the scope of the linked list");
        }
        if (loc == 1) {
            temp = head.getNext();
            head = null; //for garbage collection
            return temp;
        } else {
            int i = 1;
            temp = head;
            while (i != loc - 1) {
                temp = temp.getNext();
                i++;
            }
            temp.setNext(temp.getNext().getNext());
            return head;
        }
    }

    private int length(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.getNext();
            len++;
        }
        return len;
    }
}
