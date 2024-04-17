public class NthNode_Dele_FromLast {
    Node head;
    int size;
    NthNode_Dele_FromLast(){
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

    void delNthNode(int n){

        if (this.size == n){
            head = head.next;
            return;
        }
        Node ptr1 = head;
        Node ptr2 = head.next;

        for (int i = size-1; i > 0; i--){
            if (i == n){
                ptr1.next = ptr2.next;
                break;
            }
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
    }

    public static void main(String[] args) {

        NthNode_Dele_FromLast nd = new NthNode_Dele_FromLast();

        nd.addLast(3);
        nd.addLast(6);
        nd.addLast(4);
        nd.addLast(9);
        nd.addLast(1);

        nd.display();
        nd.delNthNode(3);
        nd.display();
    }

}
