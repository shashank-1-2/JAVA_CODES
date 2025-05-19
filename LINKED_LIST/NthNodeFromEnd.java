package LINKED_LIST;

public class NthNodeFromEnd {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void recDisplay(Node head){
        if(head == null) return;
        System.out.print(head.data+" ");
        recDisplay(head.next);
    }
    public static Node NthNode(Node head, int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        int m = size-n+1;
        temp = head;
        for(int i=1 ; i<=m-1 ; i++){
            temp = temp.next;
        }
        return temp;
    }
    public static Node NthNode2(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i=1 ; i<=n ; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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

       Node ans = NthNode(a, 2);
       System.out.println("\nBrute force '2nd last' :"+ans.data);
       Node z = NthNode2(a,3);
       System.out.println("Smart way '3rd last' : "+z.data);
    }
}
