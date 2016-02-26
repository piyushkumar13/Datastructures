package com.datastructures.linkedlist;

public class SinglyLinkedList {

    /**
     * This method creates the linked list.
     */
    public Node createList(Node[] node) {
        Node head = node[0];
        int i = 1;
        for (; i < node.length; i++) {
            node[i - 1].setData(i - 1);
            node[i - 1].setNext(node[i]);
        }
        node[i - 1].setData(i - 1);
        return head;
    }

    public void print(Node head) {
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
    public Node insertNode(int loc, Node head, int data) {
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

    /**
     * This method reversed the linked list.
     */
    public Node reverseList(Node head) {

        Node s, r, q;
        q = head;
        r = null;
        while (q != null) {

            s = r;
            r = q;
            q = q.getNext();
            r.setNext(s);
        }
        return r;
    }

    /**
     * This method merges the two sorted linked lists.
     */
    public Node mergeLists(Node head1, Node head2, Node mergedListHead) {
        Node list3 = mergedListHead;

        if (head1 == null && head2 == null) {
            return list3;
        }

        while (head1 != null && head2 != null) {
            if (head1.getData() < head2.getData()) {
                if (mergedListHead == null) {
                    list3 = new Node();
                    list3.setData(head1.getData());
                    list3.setNext(null);
                    mergedListHead = list3;
                } else {
                    Node node = new Node();
                    node.setData(head1.getData());
                    node.setNext(null);
                    list3.setNext(node);
                    list3 = list3.getNext();

                }
                head1 = head1.getNext();
            } else {
                if (mergedListHead == null) {
                    list3 = new Node();
                    list3.setData(head2.getData());
                    list3.setNext(null);
                    mergedListHead = list3;
                } else {

                    Node node = new Node();
                    node.setData(head2.getData());
                    node.setNext(null);
                    list3.setNext(node);
                    list3 = list3.getNext();
                }
                head2 = head2.getNext();
            }
        }
        completingMerge(head1, head2, list3);
        return mergedListHead;

    }

    /**
     * This program sorts the linkedlist in ascending order.
     */
    public Node sortList_UsingSelectionSort(Node head) {

        Node p = head;
        Node q = p.getNext();
        Node r = q;

        while (p.getNext() != null) {
            while (q != null) {
                if (p.getData() > q.getData()) {
                    int temp = p.getData();
                    p.setData(q.getData());
                    q.setData(temp);
                }
                q = q.getNext();
            }
            r = r.getNext();
            p = p.getNext();
            q = r;
        }
        return head;
    }

    private void completingMerge(Node head1, Node head2, Node list3) {
        if (head1 == null && head2 != null) {
            while (head2 != null) {
                Node node = new Node();
                node.setData(head2.getData());
                node.setNext(null);
                list3.setNext(node);
                list3 = list3.getNext();
                head2 = head2.getNext();
            }
        } else if (head2 == null && head1 != null) {
            while (head1 != null) {
                Node node = new Node();
                node.setData(head1.getData());
                node.setNext(null);
                list3.setNext(node);
                list3 = list3.getNext();
                head1 = head1.getNext();
            }
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
