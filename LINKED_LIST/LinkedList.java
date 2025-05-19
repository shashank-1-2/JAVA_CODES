package LINKED_LIST;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedListOperations {
        Node head = null;
        Node tail = null;
        int size = 0;

        public void insertAtTail(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;   
        }

        public void insertAtHead(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        public void insertAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid index");
                return;
            }
            if (idx == size) {
                insertAtTail(val);
                return;
            }
            if (idx == 0) {
                insertAtHead(val);
                return;
            }
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        public int getAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Wrong index");
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        public void deleteAt(int idx){
            if(idx == 0){
                head = head.next;
                size--;
                return;
            }
            Node temp = head;
            for(int i=1 ; i<idx ; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        // public int size() {
        //     int count = 0;
        //     Node temp = head; // Use a temporary node for traversal
        //     while (temp != null) {
        //         count++;
        //         temp = temp.next;
        //     }
        //     return count;
        // }
    }

    public static void main(String[] args) {
        LinkedListOperations l1 = new LinkedListOperations();
        l1.insertAtTail(2);
        l1.insertAtTail(4);
        l1.insertAtHead(7);
        l1.insertAt(2, 5);
        l1.display(); // Output: 7 2 5 4
        System.out.println("\nSize is: " + l1.size);
        System.out.println("Element at index 2: " + l1.getAt(2)); // Output: 5
        l1.deleteAt(3);
        System.out.print("After deleteing element at index '3' : ");
        l1.display();
        System.out.println("\nSize is: " + l1.size);
    }
}

