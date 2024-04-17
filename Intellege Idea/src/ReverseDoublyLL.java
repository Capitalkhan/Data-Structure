public class ReverseDoublyLL {
    Node head;
    Node tail;
    int size;
    ReverseDoublyLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    void addFirst(int data){

        Node nNode = new Node(data);
        Node temp = head;
        if(head == null){
            head = nNode;
            this.tail = nNode;
        }else{
            temp.prev = nNode;
            nNode.next = temp;
            head = nNode;
        }
        size++;
    }
    void addLast(int data){
        Node nNode = new Node(data);
        if(head == null){
            head = nNode;
            this.tail = nNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            nNode.prev = temp;
            temp.next = nNode;
            tail = nNode;
        }
        size++;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseDisplay(){
//        Node temp = head;
//        while (temp != null){
//            System.out.print(tail.data+" ");
//            tail = tail.prev;
//            temp = temp.next;
//        }
//        System.out.println();
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ReverseDoublyLL r = new ReverseDoublyLL();

        r.addFirst(4);
        r.addFirst(6);
        r.addFirst(2);
        r.addFirst(9);
        r.addFirst(1);
        r.display();
        r.reverseDisplay();
    }

}
