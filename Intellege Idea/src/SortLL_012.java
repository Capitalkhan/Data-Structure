public class SortLL_012 {
    Node head;
    int size;
    SortLL_012(){
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

    void zeroOneTwo(){

        for (int i = 2; i>= 0; i--){
            Node ptr1 = head;
            Node ptr2 = head.next;
            while (ptr2 != null){
                if (ptr2.data == i){
                    addFirst(ptr2.data);
                    size--;
                    ptr1.next = ptr2.next;
                    ptr2 = ptr2.next;
                    continue;
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
        }
    }

    public static void main(String[] args) {

        SortLL_012 s = new SortLL_012();

        s.addLast(1);
        s.addLast(1);
        s.addLast(0);
        s.addLast(0);
        s.addLast(0);
        s.addLast(0);
        s.addLast(1);
        s.addLast(2);
        s.addLast(2);
        s.addLast(2);
        s.addLast(2);
        s.addLast(1);
        s.addLast(1);
        s.addLast(1);


        s.display();

        s.zeroOneTwo();
        s.display();
    }

}
