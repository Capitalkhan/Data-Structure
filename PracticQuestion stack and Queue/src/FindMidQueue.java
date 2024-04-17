public class FindMidQueue {
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
        int findMid(){
            if (size%2 == 0){
                Node temp = head;
                for (int i = 1; i<(size/2)+1; i++){
                    temp = temp.next;
                }
                return temp.data;
            }else{
                Node temp = head;
                for (int i = 0; i<size/2; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }
        int delMid(){
            Node p1 = head;
            Node p2 = head.next;
            if (size%2 == 0){
                for (int i = 1; i<(size/2)+1; i++){
                    p1 = p2;
                    p2 = p2.next;
                }
                int a= p2.data;
                p1.next = p2.next;
                return a;
            }else{
                for (int i = 1; i<size/2; i++){
                    p1 = p2;
                    p2 = p2.next;
                }
                int a= p2.data;
                p1.next = p2.next;
                return a;
            }
        }


    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(7);
        q.enQueue(3);
        q.enQueue(4);
        q.display();
        System.out.println(q.findMid());
        System.out.println(q.delMid());
        q.display();
    }
}