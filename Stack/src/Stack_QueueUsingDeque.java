public class Stack_QueueUsingDeque {
    static class DoublyLL{
        Node head = null;
        Node tail = null;
        int size;
        class Node{
            int data;
            Node next;
            Node prev;

            Node(int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        Boolean isEmpty(){
            return head == null;
        }
        int size(){
            return size;
        }

        void insert_First(int data){
            Node nNode = new Node(data);
            if (isEmpty()){
                head = nNode;
                tail = nNode;
            }else{
                nNode.next = head;
                head.prev = nNode;
                head = nNode;
            }
            this.size++;
        }
        void insert_Last(int data){
            Node nNode = new Node(data);
            if (isEmpty()){
                head = nNode;
                tail = nNode;
            }else{
                Node temp = head;
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = nNode;
                nNode = tail;
                tail = nNode;
            }
            this.size++;

        }
        int remove_First(){
            if (isEmpty()){
                return -1;
            }
            int value = head.data;
            head = head.next;
            this.size--;

            return value;
        }
        int remove_Last(){
            if (isEmpty()){
                return -1;
            }
            Node temp = head;
            Node ptr = head.next;
            while (ptr.next != null){
                temp = ptr;
                ptr = ptr.next;
            }
            int value = ptr.data;
            temp.next = null;
            tail = temp;
            this.size--;
            return value;
        }
        void display(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        DoublyLL d = new DoublyLL();
        // stack
//        d.insert_Last(5);
//        d.insert_Last(1);
//        d.insert_Last(6);
//        d.insert_Last(3);
//        d.display();
//        d.remove_Last();
//        d.display();
//
        //Queue
        d.insert_Last(1);
        d.insert_Last(2);
        d.insert_Last(3);
        d.insert_Last(4);
        d.display();
        d.remove_First();
        d.display();
        System.out.println(d.size());

    }


}
