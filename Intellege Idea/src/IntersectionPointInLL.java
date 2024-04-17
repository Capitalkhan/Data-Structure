public class IntersectionPointInLL {
    Node head;
    int size;
    IntersectionPointInLL(){
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

    static void intersectTwoLL(Node h1, Node h2){

        Node one = h1;
        Node two = h2;

        for (int i = 0; i < 2; i++){
            one = one.next;
            two = two.next;
        }
        one.next = two;
    }

    static int getInterPoint(Node head1, Node head2){

        Node one = head1;
        Node two = head2;

        while (one != null && two != null){

            if(one.next == two) {
                return two.data;
            }else if(two.next == one){
                return one.data;
            }

            one = one.next;
            two = two.next;
        }
        return -1;
    }

    public static void main(String[] args) {

        IntersectionPointInLL ip1 = new IntersectionPointInLL();

        ip1.addLast(4);
        ip1.addLast(5);
        ip1.addLast(1);
        ip1.addLast(8);
        ip1.addLast(6);
        ip1.addLast(1);
        ip1.addLast(0);
        ip1.display();

        IntersectionPointInLL ip2 = new IntersectionPointInLL();

        ip2.addLast(1);
        ip2.addLast(2);
        ip2.addLast(3);
        ip2.addLast(4);
        ip2.display();

        intersectTwoLL(ip1.head,ip2.head);
        System.out.println(getInterPoint(ip1.head,ip2.head));

//        ip1.display();
    }
}
