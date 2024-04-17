public class SumOfTwoList {
    Node head;
    int size;
    SumOfTwoList(){
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

    int sum(Node h1,Node h2){
        String str1 = "";
        String str2 = "";

        while (h1 != null){
            str1 += String.valueOf(h1.data);
            h1 = h1.next;
        }
        while (h2 != null){
            str2 += String.valueOf(h2.data);
            h2 = h2.next;
        }

        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }

    public static void main(String[] args) {

        SumOfTwoList s1 = new SumOfTwoList();

        s1.addLast(5);
        s1.addLast(6);
        s1.addLast(3);

        SumOfTwoList s2 = new SumOfTwoList();

        s2.addLast(8);
        s2.addLast(4);
        s2.addLast(2);

        System.out.println(s2.sum(s1.head,s2.head));
    }
}
