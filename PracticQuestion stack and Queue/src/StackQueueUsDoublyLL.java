public class StackQueueUsDoublyLL {
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

        void push(int data){
            Node nNode = new Node(data);

            size++;
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
        int pop(){
            if (size == 0){
                return -1;
            }

            --size;
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            int result = temp.data;
            tail = temp.prev;
            temp.prev.next = null;
            return result;
        }
        void display(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        void enQueue(int data){
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
            int result = head.data;
            head = head.next;
            return result;
        }
    }

    public static void main(String[] args) {
        DoublyLL d = new DoublyLL();

        // for stack
        d.push(4);
        d.push(6);
        d.push(2);
        d.push(9);

        d.display();
        System.out.println(d.pop());
        d.display();

        // for Queue
        d.enQueue(4);
        d.enQueue(6);
        d.enQueue(2);
        d.enQueue(9);

        d.display();
        System.out.println(d.deQueue());
        d.display();
    }

}
