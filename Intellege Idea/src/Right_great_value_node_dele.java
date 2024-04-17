public class Right_great_value_node_dele {
    Node head;
    Node tail;
    int size;
    Right_great_value_node_dele(){
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
            temp.next = nNode;
            nNode.prev = temp;
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


    /*
    a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. */

    void dRNValue(){

        while (!(head.data > head.next.data)){
            if (head.data < head.next.data){
                head = head.next;
            }
        }
        Node ptr1 = head;
        Node ptr2 = head.next;
        while (ptr2.next != null && ptr2 != null){
            if (ptr2.data < ptr2.next.data){
                ptr1.next = ptr2.next;
            }
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }

    }



    public static void main(String[] args) {

        Right_great_value_node_dele r = new Right_great_value_node_dele();
        /*
    a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. */

        r.addLast(12);
        r.addLast(15);
        r.addLast(10);
        r.addLast(11);
        r.addLast(5);
        r.addLast(6);
        r.addLast(2);
        r.addLast(3);

        r.display();
        r.dRNValue();
        r.display();

    }
}
