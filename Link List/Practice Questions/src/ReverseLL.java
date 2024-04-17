public class ReverseLL {
    int size;
    Node head;
    ReverseLL(){
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
            nNode.next = head;
            head = nNode;
        }
        ++size;
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
        ++size;
    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse(){
        Node f = head;
        Node s = head.next;

        while (s != null){
            Node t = s.next;
            s.next = f;
            //update
            f = s;
            s = t;
        }
        head.next = null;
        head = f;
    }

    public static void main(String[] args) {

        ReverseLL r = new ReverseLL();

        r.addLast(3);
        r.addLast(7);
        r.addLast(9);
        r.addLast(4);
        r.addLast(5);
        r.addLast(1);

        r.display();

        r.reverse();

        r.display();
    }
}
