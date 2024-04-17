public class Multi_TwoLL {
    Node head;
    int size;
    Multi_TwoLL(){
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

    int multiply2LL(Node head1,Node head2){

        String num1 = "";
        Node first = head1;
        Node second = head2;

        while (first != null){
            num1 = num1+ String.valueOf(first.data);
            first = first.next;
        }

        String num2 = "";
        while (second != null){
            num2 = num2+ String.valueOf(second.data);
            second = second.next;
        }
        System.out.println(num1 +" "+num2);
        return Integer.parseInt(num1)* Integer.parseInt(num2);

    }

    public static void main(String[] args) {

        Multi_TwoLL mt1 = new Multi_TwoLL();

        mt1.addLast(4);
        mt1.addLast(3);
        mt1.addLast(1);
        mt1.display();


        Multi_TwoLL mt2 = new Multi_TwoLL();

        mt2.addLast(1);
        mt2.addLast(3);
        mt2.addLast(2);
        mt2.display();

        System.out.println(mt2.multiply2LL(mt1.head,mt2.head));
    }
}
