import java.util.Scanner;

class Node{
    String data;
    Node next;

    Node(String data){
        this.data = data;
        this.next = null;
    }

}

public class Practice_Q {

    Node head;
    int size;
    Practice_Q(){
        this.head = null;
        this.size = 0;
    }



    void addFirst(String data){

        Node nNode = new Node(data);

        if(head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        size++;

    }


    void addLast(String data){

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

    int getSize(){
        return this.size;
    }

    String nthNumberFinding(int n){

        Node temp = head;
        int nEle = this.getSize() - n + 1;
        int prevEle = this.getSize() - n;

        for(int i = 0; i < nEle-1; i++){
            temp = temp.next;
            //System.out.println(temp.data);
        }

        Node temp2 = head;
        for (int i = 1; i < prevEle; i++){
            temp2= temp2.next;
        }
        temp2.next = temp2.next.next;

        return temp.data;



    }

    Boolean palindram(){
        Boolean flag = true;

        int halfLl = this.getSize() /2;
        Node temp = head;
        for(int i =0; i<halfLl; i++){
            temp = temp.next;
        }
        Node nNode = halfReverse(temp);
        temp = head;
        while (nNode != null){
            if (temp.data != nNode.data){
                return false;
            }
            temp = temp.next;
            nNode = nNode.next;
        }
        return true;

    }

    Node halfReverse(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node nNode = halfReverse(head.next);
        head.next.next = head;
        head.next = null;

        return nNode;
    }

    public static void main(String[] args) {
        Practice_Q n = new Practice_Q();

        n.addFirst("a");
        n.addFirst("b");
        n.addFirst("b");
////        n.addFirst("d");
//        n.addFirst("e");
//        n.addFirst("f");

        n.display();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter N ele : ");
//        int x = sc.nextInt();
//
//        System.out.println(n.nthNumberFinding(x));
//
//        n.display();

        if(n.palindram()){
            System.out.println("yes");
        }else{
            System.out.println("Not");
        }
    }
}
