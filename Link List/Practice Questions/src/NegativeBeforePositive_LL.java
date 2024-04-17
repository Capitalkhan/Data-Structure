public class NegativeBeforePositive_LL {
    int size;
    Node head;
    NegativeBeforePositive_LL(){
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

    void nBPSort(){

        Node temp = head;
        Node temp2 = head.next;

        while (temp2 != null){
            
            if(temp2.data < 0){

                addFirst(temp2.data);
                --size;
                temp.next = temp2.next;
                temp2 = temp2.next;
                continue;
            }
            temp = temp2;
            temp2 = temp2.next;
        }
    }
    public static void main(String[] args) {
        NegativeBeforePositive_LL np = new NegativeBeforePositive_LL();

        np.addLast(-21);
        np.addLast(-25);
        np.addLast(32);
        np.addLast(-34);
        np.addLast(78);
        np.addLast(78);

        np.display();

        np.nBPSort();

        np.display();

    }

}
