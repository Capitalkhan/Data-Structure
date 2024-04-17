public class Cycle_in_LL {

    Node head;
    int size;
    Cycle_in_LL(){
        this.head = null;
        this.size = 0;
    }

    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addLast(int data){
        Node nNode  = new Node(data);
        if(head == null){
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

    void cycleLL(){

        Node temp1 = head;
        Node temp2 = head.next;

        while (temp2.next != null){
            temp1 = temp2;
            temp2 = temp2.next;
        }
        temp2.next = temp1;

    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Boolean detectCycle(){
        if(head == null){
            return false;
        }

        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null){

            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                return true;
            }
        }

        return false;
    }

    void removingCycle(){

        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                turtle = head;
                while (hare != null){
                    hare = hare.next;
                    turtle = turtle.next;

                    if(hare == turtle){
                        turtle.next = null;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Cycle_in_LL c = new Cycle_in_LL();

        c.addLast(4);
        c.addLast(5);
        c.cycleLL();

        if(c.detectCycle()){
            System.out.println("Youre Link list have a cycle");
        }else{
            System.out.println("Youre Link list dos,nt have cycle");
        }

        c.removingCycle();

        c.addLast(2);
        c.addLast(8);
        c.addLast(7);
        c.addLast(9);

        c.display();
    }
}
