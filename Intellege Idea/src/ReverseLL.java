public class ReverseLL {
    Node head;
    int size;
    ReverseLL(){
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

    Node reverseItratively(){
        Node curr = head;
        Node prev = null;
        while (curr != null){
            Node temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    Node reverseRecursively(Node h){
        if (h == null || h.next == null){
            return h;
        }

        Node newHead = reverseRecursively(h.next);
        Node headNext = h.next;
        headNext.next = h;
        h.next = null;
        return newHead;

    }

    public static void main(String[] args) {
        ReverseLL r = new ReverseLL();

        r.addLast(4);
        r.addLast(8);
        r.addLast(2);
        r.addLast(9);

        r.display();
//        Node temp = r.reverseItratively();
//        while(temp != null){
//            System.out.print(temp.data+" ");
//            temp = temp.next;
//        }
//        System.out.println();

        Node temp = r.reverseRecursively(r.head);

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }
}
