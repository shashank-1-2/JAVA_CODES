package LINKED_LIST;

public class DeleteNthNodeFromEnd {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node deleteNthFromEnd(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i=1 ; i<=n ; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
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

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        recDisplay(a);
        a = deleteNthFromEnd(a, 6); //3rd element from end is 8
        System.out.println();
        recDisplay(a);

    }
}
