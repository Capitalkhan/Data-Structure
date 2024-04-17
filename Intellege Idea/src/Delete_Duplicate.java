public class Delete_Duplicate {
    Node head;
    int size;
    Delete_Duplicate(){
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

    void deleteDuplicate(){
        Node temp = head;

        while (temp != null){
            Node ptr1 = temp;
            Node ptr2 = temp.next;
            while (ptr2 != null){
                if (temp.data == ptr2.data){
                    ptr1.next = ptr2.next;
                    ptr2 = ptr2.next;
                    continue;
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Delete_Duplicate dp = new Delete_Duplicate();

        dp.addLast(2);
        dp.addLast(2);
        dp.addLast(2);
        dp.addLast(7);
        dp.addLast(4);
        dp.addLast(2);
        dp.addLast(3);
        dp.addLast(3);
        dp.addLast(3);
        dp.addLast(3);
        dp.addLast(3);
        dp.addLast(3);
        dp.addLast(3);
        dp.display();

        dp.deleteDuplicate();
        dp.display();
    }


}
