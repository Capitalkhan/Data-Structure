public class RearngeLL {
    Node head;
    int size;
    RearngeLL(){
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
    Node reverse(Node h){

        Node curr = h;
        Node prev = null;
        while (curr != null){
            Node temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    Node rearrange(Node h){

        if (h == null || h.next == null){
            return h;
        }

        Node hare = h;
        Node tutle = h;

        while (hare.next != null && hare.next.next != null){
            tutle = tutle.next;
            hare = hare.next.next;
        }
        Node node1 = h;
        Node node2 = tutle.next;
        tutle.next = null;

        node2 = reverse(node2);

        h = new Node(0);
        Node curr = h;

        while (node1 != null || node2 != null){
            if (node1 != null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if (node2 != null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        return h.next;


















    }

    public static void main(String args[])
    {


        RearngeLL r = new RearngeLL();

        r.addLast(7);
        r.addLast(3);
        r.addLast(8);
        r.addLast(6);
        r.addLast(9);

        r.display();
        Node temp = r.rearrange(r.head);
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

