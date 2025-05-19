package LINKED_LIST;
public class ReversingLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void recDisplay(Node head){
        if(head == null) return;
        Node temp = head;
        System.out.print(temp.data+" ");
        recDisplay(temp.next);
    }
    public static void revDisplay(Node head){
        if(head == null) return;
        Node temp = head;
        revDisplay(temp.next);
        System.out.print(temp.data+" ");
    }
    public static Node recReverese(Node head){
        if(head.next == null) return head;
        Node newHead = recReverese(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(8);
        Node e = new Node(10);
        Node f = new Node(12);
        Node g = new Node(14);
        Node h = new Node(16);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        System.out.print("Linked list : ");
        recDisplay(a);
        System.out.print("\nReversed linked list : ");
        revDisplay(a);

        Node r = recReverese(a);
        System.out.print("\nRecursive Reversed linked list : ");
        recDisplay(r);
    }
}
