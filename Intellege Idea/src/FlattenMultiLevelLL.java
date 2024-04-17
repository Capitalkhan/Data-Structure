import java.util.*;
import java.util.Scanner;

public class FlattenMultiLevelLL {
    Node head;
    int size;
    FlattenMultiLevelLL(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;
        Node child;
        Node(int data){
            this.data = data;
            this.next = null;
            this.child = null;
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


    void modifyAllLL(Node h1,Node h2,Node h3,Node h4,Node h5,Node h6,Node h7,Node h8){


        this.head = h1;
        h3.child = h6;
        h5.child = h7;
        h2.next.child = h4;
        h2.next.next.child = h5;
        h1.child = h2;
        h1.next.next.next.child = h3;
        h6.child = h8;
    }

    void displayModifyLL() {

//        //display using queue
//        Node temp = head;
//        Queue<Node> q = new LinkedList<>();
//
//        while (temp != null){
//            if (temp.next == null){
//                temp.next = q.poll();
//            }
//
//            if (temp.child != null){
//                q.add(temp.child);
//            }
//            System.out.print(temp.data+" ");
//            temp = temp.next;
//        }

        //Without Q Display LL

//        First we need to convert multi level link list in single level

        Node temp = null;
        Node curr = head;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        while (curr != last) {

            if (curr.child != null) {
                last.next = curr.child;
                temp = curr.next;
                while (temp.next != null) {
                    temp = temp.next;
                }
                // because we print all number include child
                last = temp;
            }
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.print(curr.data);

    }
//    10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15


    public static void main(String[] args) {

        FlattenMultiLevelLL n1 = new FlattenMultiLevelLL();
        n1.addLast(10);
        n1.addLast(5);
        n1.addLast(12);
        n1.addLast(7);
        n1.addLast(11);

        FlattenMultiLevelLL n2 = new FlattenMultiLevelLL();
        n2.addLast(4);
        n2.addLast(20);
        n2.addLast(13);

        FlattenMultiLevelLL n3 = new FlattenMultiLevelLL();
        n3.addLast(17);
        n3.addLast(6);

        FlattenMultiLevelLL n4 = new FlattenMultiLevelLL();
        n4.addLast(2);

        FlattenMultiLevelLL n5 = new FlattenMultiLevelLL();
        n5.addLast(16);

        FlattenMultiLevelLL n6 = new FlattenMultiLevelLL();
        n6.addLast(9);
        n6.addLast(8);

        FlattenMultiLevelLL n7 = new FlattenMultiLevelLL();
        n7.addLast(3);

        FlattenMultiLevelLL n8 = new FlattenMultiLevelLL();
        n8.addLast(19);
        n8.addLast(15);

        //Modify all link list in one form

        FlattenMultiLevelLL mLL = new FlattenMultiLevelLL();

        mLL.modifyAllLL(n1.head,n2.head,n3.head,n4.head,n5.head,n6.head,n7.head,n8.head);
        mLL.displayModifyLL();



    }

}
