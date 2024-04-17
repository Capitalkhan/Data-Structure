public class CopyLL {
    int size;
    Node head;
    CopyLL(){
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

    Node copyMethod(){
        Node temp = head;
        Node copyL = head;

        while (temp != null){

            copyL.data = temp.data;
            temp = temp.next;
            copyL = copyL.next;
        }

        return copyL;
    }

    public static void main(String[] args) {

        CopyLL n = new CopyLL();

        n.addLast(3);
        n.addLast(5);
        n.addLast(8);
        n.addLast(9);
        n.addLast(3);
        n.addLast(5);

        n.display();
        Node copy = n.copyMethod();

        System.out.println(n.copyMethod());
//        while (copy != null){
//            System.out.print(copy.data+" ");
//            copy = copy.next;
//        }
//        System.out.println();
//

    }

}
