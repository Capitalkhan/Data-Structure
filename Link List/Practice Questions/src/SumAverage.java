import java.util.Scanner;

public class SumAverage {
    int size;
    Node head;
    SumAverage(){
        this.size = 0;
        this.head = null;
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

    int sum(){

        Node temp = head;
        int sum = 0;
        while (temp != null){
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }
    double average(){
        return sum()/size;
    }

    public static void main(String[] args) {

        SumAverage sa = new SumAverage();

        Scanner sc = new Scanner(System.in);

        sa.addLast(10);
        sa.addLast(20);
        sa.addLast(30);
        sa.addLast(40);
        sa.addLast(50);

        System.out.println(sa.sum());
        System.out.println(sa.average());
    }

}
