package LINKED_LIST;

public class FindingMiddleElement {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node middleElement(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void recDisplay(Node head){
        if(head == null) return;
        Node temp = head;
        System.out.print(temp.data+" ");
        recDisplay(temp.next);
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

        recDisplay(a);
        System.out.println("\nMiddle element is : "+middleElement(a).data);
    }
}
