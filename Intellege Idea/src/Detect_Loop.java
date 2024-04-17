public class Detect_Loop {
    Node head;
    int size;
    Detect_Loop(){
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

    void makingLoopinLL(){

        Node p1 = head;
        Node p2 = head.next;

        for (int i =0; i < 2; i++){
            p1 = p2;
            p2 = p2.next;
        }
        p2.next = p1;
    }

    Boolean detectionOfLoop(){

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

    void deleteLoopFromLL(){
        Node hare = head;
        Node turtle = head;

        int i = 0;
        while (hare != null || hare.next != null){

            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                ++i;
                if (i == 2){
                    hare.next.next = null;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {

        Detect_Loop dl = new Detect_Loop();

        dl.addLast(1);
        dl.addLast(2);
        dl.addLast(3);
        dl.addLast(4);

        dl.display();
        dl.makingLoopinLL();
//        dl.display();

        if(dl.detectionOfLoop()){
            System.out.println("Loop exist");
        }else{
            System.out.println("There is no loop");
        }
        System.out.println();

        dl.deleteLoopFromLL();
        if(dl.detectionOfLoop()){
            System.out.println("Loop exist");
        }else{
            System.out.println("There is no loop");
        }

        dl.display();
    }

}
