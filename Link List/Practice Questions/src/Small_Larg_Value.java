public class Small_Larg_Value {
    int size;
    Node head;
    Small_Larg_Value(){
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
            nNode.next = head.next;
            head = nNode;
        }
        size++;
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
        size++;
    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    int smallest(){
        Node temp = head.next;
        int small = head.data;

        while (temp != null){
            if(temp.data <  small){
                small = temp.data;
            }

            temp = temp.next;
        }

        return small;
    }

    int largest(){
        Node temp = head.next;
        int larger = head.data;

        while (temp != null){
            if(temp.data >  larger){
                larger = temp.data;
            }

            temp = temp.next;
        }

        return larger;
    }

    public static void main(String[] args) {

        Small_Larg_Value sl = new Small_Larg_Value();

        sl.addLast(4);
        sl.addLast(7);
        sl.addLast(3);
        sl.addLast(1);
        sl.addLast(9);

        sl.display();

        System.out.println(sl.smallest());
        System.out.println(sl.largest());
    }


}
