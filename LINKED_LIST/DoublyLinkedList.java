package LINKED_LIST;

public class DoublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        display(head.next);
    }

    public static void displayRandom(Node random) {
        Node temp = random;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head, int x) {
        Node t = new Node(x);
        if (head != null) {
            t.next = head;
            head.prev = t;
        }
        return t;
    }

    public static Node insertAtTail(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node t = new Node(x);
        temp.next = t;
        t.prev = temp;
        return head;
    }

    public static Node insertAt(Node head, int idx, int x) {
        if (idx == 0) {
            return insertAtHead(head, x);
        }
        Node temp = head;
        for (int i = 0; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return head; // Index out of bounds
        Node t = new Node(x);
        t.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = t;
        }
        temp.next = t;
        t.prev = temp;
        return head;
    }

    public static Node deleteAt(Node head, int idx) {
        if (head == null) return null;
        if (idx == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Node temp = head;
        for (int i = 0; i < idx && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return head; // Index out of bounds
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(8);
        Node e = new Node(10);

        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;

        displayRandom(d);
        Node newHead = insertAtHead(a, 35);
        display(newHead);
        System.out.println();

        newHead = insertAtTail(newHead, 7);
        display(newHead);
        System.out.println();

        newHead = insertAt(newHead, 3, 5);
        display(newHead);
        System.out.println();

        newHead = deleteAt(newHead, 3);
        display(newHead);
        System.out.println();
    }
}
