public class DeleteHead {
    Node head;
    int size;
    DeleteHead(){
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


    public void deleteNode(Node head2){
        head = head2.next;
    }




    public static void main(String[] args) {

        DeleteHead s = new DeleteHead();

        s.addLast(3);
        s.addLast(4);
        s.addLast(7);
        s.addLast(1);
        s.addLast(8);

        s.display();

        System.out.println("After");
        s.deleteNode(s.head);
        s.display();
    }
}
