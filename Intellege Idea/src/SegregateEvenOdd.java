public class SegregateEvenOdd {
    Node head;
    int size;
    SegregateEvenOdd(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data){

        Node nNode = new Node(data);

        if(head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        size++;

    }


    void addLast(int data){

        Node nNode = new Node(data);

        if(head == null){
            head = nNode;
        }else{
            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = nNode;
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

    void segregate(){
        Node ptr1 = head;
        Node ptr2 = head.next;

        while (ptr2 != null){
            if (ptr2.data % 2 == 0){
                addFirst(ptr2.data);
                size--;
                ptr1.next = ptr2.next;
                ptr2 = ptr2.next;
                continue;
            }
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
    }

    public static void main(String[] args) {
        SegregateEvenOdd ll = new SegregateEvenOdd();

        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(4);
        ll.addLast(4);
        ll.addLast(11);

        ll.display();
        ll.segregate();
        ll.display();
    }
}
