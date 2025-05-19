package LINKED_LIST;

public class Basic {
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void insertAtTail(Node head, int val){
        Node temp = new Node(val);
        Node newNode = head;
        while(newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next = temp ;
    }
    //using recursion
    public static void recDisplay(Node head){
        if(head == null) return;
        System.out.print(head.data+" ");
        recDisplay(head.next);
    }
    //lenght of linked list
    public static int length(Node head){
        int count =0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public static class Node{
        int data;   //value
        Node next;  //address of next node
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
       Node a = new Node(5);
       Node b = new Node(3);
       Node c = new Node(9);
       Node d = new Node(8);
       Node e = new Node(16);
        //5  3  9  8  16
        a.next = b; // 5 -> 3  9  8  16
        b.next = c; // 5 -> 3 -> 9  8  16
        c.next = d; // 5 -> 3 -> 9 -> 8  16
        d.next = e; // 5 -> 3 -> 9 -> 8 -> 16

        System.out.println("a for a.data : "+a.data);
        System.out.println("b for a.next.data : "+a.next.data);
        System.out.println("b for b.data : "+b.data); 
        System.out.println("c for a.next.next.data : "+a.next.next.data); 
        
        display(a);
        System.out.print("\nUsing recursion : ");
        recDisplay(a);
        System.out.println("\nLength of linked list is : "+length(a));

        insertAtTail(a, 77);
        recDisplay(a);
        
        
        // System.out.print("Printing using loops : ");
        // Node temp = a;
        // while(temp != null){    //printing the linked list
        //     System.out.print(temp.data+" ");
        //     temp = temp.next;
        // }
    }
}
