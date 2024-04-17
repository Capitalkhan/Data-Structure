public class CloneNextRandomPointer {
    Node head;
    int size;
    CloneNextRandomPointer(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;
        Node random;

        Node(int data){
            this.data = data;
            this.next = null;
            this.random = null;
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
    void setRandom(){
        Node temp = head;

        temp.random = temp.next.next;
        temp.next.random = temp;
        temp.next.next.random = temp.next.next.next;

    }
    void displayNext(Node temp){


        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    void displayRandom(Node temp){


        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.random;
        }
        System.out.println();
    }

    Node cloneNextRandPointer(Node head){
        Node curr = head;

        // insertion new node in every node of curr Link list
        while (curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        // set random pointer of new Node
        while (curr != null){
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }

        // separating both the link list
        Node orignal = head;
        Node copy = head.next;

        Node temp = copy;

        while (orignal != null){
            orignal.next = orignal.next.next;
            copy.next = (copy.next != null)? copy.next.next : null;

            orignal = orignal.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        CloneNextRandomPointer c = new CloneNextRandomPointer();
        c.addLast(1);
        c.addLast(2);
        c.addLast(3);
        c.addLast(4);

        c.setRandom();

        c.displayNext(c.head);
        c.displayRandom(c.head);

        CloneNextRandomPointer c2 = new CloneNextRandomPointer();

        System.out.println("Duplicate link list with random pointer");
        Node temp = c2.cloneNextRandPointer(c.head);


        c2.displayNext(temp);
        c2.displayRandom(temp);
    }
}
