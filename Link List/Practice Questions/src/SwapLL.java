
public class SwapLL {
    int size;
    Node head;
    SwapLL(){
        this.size = 0;
        this.head = null;
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
        if(this.head == null){
            head = nNode;
        }else{
            nNode.next = head.next;
            head = nNode;
        }
        size++;
    }

    void addLast(int data){


        Node nNode = new Node(data);
        if(this.head == null){
            head = nNode;
        }else{
            Node temp = head;

            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = nNode;
        }
        size++;
    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void swap(){
        Node temp1 = head;
        Node temp2 = head;

        while (temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = temp1;
        head = temp1.next;
        temp1.next = null;

    }
    public static void main(String[] test) {

        SwapLL s = new SwapLL();

        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);
        s.addLast(5);

        s.display();
        System.out.println("after");
        s.swap();
        s.display();

    }
}
