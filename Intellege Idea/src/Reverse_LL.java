public class Reverse_LL {
    Node head;
    int size;
    Reverse_LL(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }

    }

    void addFirst(String data){

        Node nNode = new Node(data);

        if(head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        size++;

    }


    void addLast(String data){

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

    void reverseLL(){

        if(head == null || head.next == null){
            return;
        }

        Node pre = head;
        Node curr = pre.next;

        while (curr != null){
            Node nex = curr.next;
            curr.next = pre;

            //update
            pre = curr;
            curr = nex;

            // System.out.println( pre.data +" "+curr.data+" "+nex.data);
        }
        head.next = null;
        head = pre;

    }

    // public Node argumentReverse(Node head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }

    //     Node pre = head;
    //     Node curr = pre.next;

    //     while (curr != null){
    //         Node nex = curr.next;
    //         curr.next = pre;

    //         //update
    //         pre = curr;
    //         curr = nex;

    //         // System.out.println( pre.data +" "+curr.data+" "+nex.data);
    //     }
    //     head.next = null;
    //     head = pre;

    //     return head;
    // }

    // void argumentDisplay(Node head){

    //     Node temp = head;

    //     while(temp != null){
    //         System.out.print(temp.data +" ");
    //         temp = temp.next;
    //     }
    //     System.out.println();
    // }

    public Node reverseRecursive(Node head){



        if(head == null || head.next == null){
            return head;
        }

        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    void deletelast(){

        Node temp = head;
        Node temp2 = temp.next;

        while(temp2.next != null){
            temp = temp2;
            temp2 = temp2.next;
        }
        temp.next = temp2.next;
        size--;
    }

    void display(){

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Boolean hasCycle(){

        if(head == null){
            return false;
        }
        Node hare = head;
        Node tartle = head;

        while(hare != null && hare.next != null){

            hare = hare.next.next;
            tartle = tartle.next;

            if(hare.next.next == tartle.next){
                return true;
            }


        }

        return false;
    }

    public static void main(String[] args) {


        Reverse_LL ll = new Reverse_LL();
        ll.addLast("a");
        ll.addLast("b");
        ll.addLast("c");
        ll.addLast("d");
        ll.addLast("e");

        // ll.display();

        // System.out.println("After");

        // ll.reverseLL();
        // // ll.head = ll.reverseRecursive(ll.head);

        // ll.display();


    }
}
