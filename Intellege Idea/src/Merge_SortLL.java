import java.util.Scanner;

public class Merge_SortLL {
    Node head;
    int size;
    Merge_SortLL(){
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

    Node mergeSort(Node head1, Node head2){

        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }

        Node one = head1;
        Node two = head2;
        Node temp = head;

        while (one != null && two != null){
            if(one.data < two.data){

                addLast(one.data);
                one = one.next;
            }else if(one.data > two.data){

                addLast(two.data);
                two = two.next;
            }
            else if (one.data == two.data){
                addLast(one.data);
                addLast(two.data);
                one = one.next;
                two = two.next;
            }
        }

        if(one != null){
            addLast(one.data);
        }else if (two != null){
            addLast(two.data);
        }
        return head;
    }

//    Node create(){
//        Scanner sc = new Scanner(System.in);
//
//        for(int i = 0;i < 3; i++){
//            System.out.print("Enter data : ");
//            int data = sc.nextInt();
//            Node nNode = new Node(data);
//
//            if(head == null){
//                head = nNode;
//            }else{
//                Node temp2 = head;
//
//                while(temp2.next != null){
//                    temp2 = temp2.next;
//                }
//                temp2.next = nNode;
//            }
//        }
//
//        return head;
//    }


    public static void main(String[] args) {


        Merge_SortLL s1 = new Merge_SortLL();

        s1.addLast(2);
        s1.addLast(3);
        s1.addLast(8);
//        Node n1 = s1.create();
        s1.display();
        Merge_SortLL s2 = new Merge_SortLL();

        s2.addLast(1);
        s2.addLast(2);
        s2.addLast(3);
//        Node n2 = s2.create();
        s2.display();
        Merge_SortLL s3 = new Merge_SortLL();

        Node n3 = s3.mergeSort(s1.head,s2.head);
        s3.display();
    }


}
