public class ReverseQueue {
    static Node head = null;
    static Node tail = null;
    static int size = 0;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class Queue {

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void enQueue(int data) {
            size++;
            Node nNode = new Node(data);

            if (head == null) {
                head = nNode;
                tail = nNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nNode;
                nNode.prev = temp;
                tail = nNode;
            }
        }

        int deQueue() {
            if (head == null) {
                return -1;
            }
            --size;
            int result = head.data;
            head = head.next;
            return result;
        }

        Queue reverse(Node temp){
            Queue q2 = new Queue();
            if (temp.next == null){
                return q2;
            }

            int data = deQueue();
            reverse(temp.next);

            q2.enQueue(data);
            return q2;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.display();

        Queue q2 = q.reverse(head);
        q2.display();
    }
}