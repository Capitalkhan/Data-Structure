public class ZeroOneTwo {
    int size;
    Node head;
    ZeroOneTwo(){
        this.size = 0;
        this.head = null;
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
        if(this.head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        ++size;
    }

    void addLast(int data){

        Node nNode = new Node(data);
        if(this.head == null){
            head = nNode;
        }else{
            Node temp = head;

            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = nNode;
        }
        ++size;
    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void sorting(){
//        Node temp = head;
//        Node ptr = head;

        for(int i = 2; i >=0; i--){
            Node temp = head;
            Node ptr = head.next;

            while (ptr != null){

                if(ptr.data == i){
                    addFirst(ptr.data);
                    --size;
                    temp.next = ptr.next;
                    ptr = ptr.next;
                    continue;
                }
                temp = ptr;
                ptr = ptr.next;
            }
        }


//        Node temp = head;
//        Node ptr = head.next;
//        while (ptr != null){
//
//            if(ptr.data == 2){
//                addFirst(ptr.data);
//                --size;
//                temp.next = ptr.next;
//                ptr = ptr.next;
//                continue;
//            }
//            temp = ptr;
//            ptr = ptr.next;
//        }
//
//        Node temp2 = head;
//        Node ptr2 = head.next;
//        while (ptr2 != null){
//
//            if(ptr2.data == 1){
//                addFirst(ptr2.data);
//                --size;
//                temp2.next = ptr2.next;
//                ptr2 = ptr2.next;
//                continue;
//            }
//            temp2 = ptr2;
//            ptr2 = ptr2.next;
//        }
//
//        Node temp3 = head;
//        Node ptr3 = head.next;
//        while (ptr3 != null){
//
//            if(ptr3.data == 0){
//                addFirst(ptr3.data);
//                --size;
//                temp3.next = ptr3.next;
//                ptr3 = ptr3.next;
//                continue;
//            }
//            temp3 = ptr3;
//            ptr3 = ptr3.next;
//        }
    }

    public static void main(String[] args) {
        ZeroOneTwo x = new ZeroOneTwo();

        x.addLast(2);
        x.addLast(1);
        x.addLast(1);
        x.addLast(2);
        x.addLast(1);
        x.addLast(0);
        x.addLast(2);
        x.addLast(0);
        x.addLast(0);
        x.addLast(1);
        x.addLast(2);
        x.addLast(0);

        x.display();

        x.sorting();
        x.display();
    }

}
