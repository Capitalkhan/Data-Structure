import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortKList {

    ArrayList<LinkedList<Node>>[] list = new ArrayList[3];

    Node head;
    int size;
    SortKList(){
        this.head = null;
        this.size = 0;
    }

    static class Node{
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
    void display(Node temp){


        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    void mergeKLinkList(ArrayList<Node> l){

//        System.out.println(l.get(0).peek().data);
    }

    public static void main(String[] args) {

        SortKList s1 = new SortKList();

        s1.addLast(5);
        s1.addLast(6);
        s1.addLast(7);

        SortKList s2 = new SortKList();
        s1.addLast(1);
        s1.addLast(2);
        s1.addLast(3);

        SortKList s3 = new SortKList();
        s1.addLast(0);
        s1.addLast(4);
        s1.addLast(9);

        SortKList s4 = new SortKList();

        ArrayList<Node>[] list = new ArrayList[3];

    }
}
