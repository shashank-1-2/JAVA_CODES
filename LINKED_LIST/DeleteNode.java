package LINKED_LIST;

public class DeleteNode {   //Leet Code 237
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void DeleteAt(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
    public static void recDisplay(Node head){
        if(head == null) return;
        System.out.print(head.data+" ");
        recDisplay(head.next);
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

        recDisplay(a);
        DeleteAt(c);
        System.out.print("\nAfter deleteing node 'c = 6' : ");
        recDisplay(a);

    } 
}
