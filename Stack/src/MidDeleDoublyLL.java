public class MidDeleDoublyLL {
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

        int midEle(){
            Node ptr1 = head;
            Node ptr2 = head.next;
            int mid = 0;

            if (size%2 == 0){
                for (int i =2; i < (size/2)+1; i++){
                    ptr1 = ptr2;
                    ptr2 = ptr2.next;
                }
                mid = ptr2.data;
                ptr1.next = ptr2.next;
                ptr2.next.prev = ptr1;
            }else{
                for (int i =2; i<=size/2; i++){
                    ptr1 = ptr2;
                    ptr2 = ptr2.next;
                }
                mid = ptr2.data;
                ptr1.next = ptr2.next;
                ptr2.next.prev = ptr1;
            }
            return mid;
        }
    }

    public static void main(String[] args) {

        DoublyLL dl = new DoublyLL();
        dl.insert_Last(1);
        dl.insert_Last(2);
        dl.insert_Last(3);
        dl.insert_Last(4);
        dl.insert_Last(9);
        dl.insert_Last(4);
        dl.display();
        System.out.println(dl.midEle());
        dl.display();


    }
}
