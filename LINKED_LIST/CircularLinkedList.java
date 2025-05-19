package LINKED_LIST;

public class CircularLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void DisplayCircular(Node head) {
        Node temp = head; // Start from the head node
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head); // Loop until we return to the head
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(8);
        Node e = new Node(10);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        DisplayCircular(a);

    }
}
