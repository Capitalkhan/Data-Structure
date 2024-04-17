import java.util.Queue;

public class ReverseKEleQueue {
    static Node head = null;
    static Node tail = null;
    static int size = 0;

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLL{

        void display(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        void enQueue(int data){
            size++;
            Node nNode = new Node(data);

            if (head == null){
                head = nNode;
                tail = nNode;
            }else{
                Node temp = head;
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = nNode;
                nNode.prev = temp;
                tail = nNode;
            }
        }
        int deQueue(){
            if (head == null){
                return -1;
            }
            --size;
            int result = head.data;
            head = head.next;
            return result;
        }

        void reverse(int k){ // reverse k element from queue
            if (k == 0){
                return;
            }

            int a = deQueue();
            reverse(--k);
            enQueue(a);

        }
    }

    public static void main(String[] args) {

        DoublyLL s = new DoublyLL();

        s.enQueue(1);
        s.enQueue(2);
        s.enQueue(3);
        s.enQueue(4);
        s.display();
        s.reverse(2);

        for (int i = 0; i<size - 2; i++){
            int b = s.deQueue();
            s.enQueue(b);
        }
        s.display();

    }

}
