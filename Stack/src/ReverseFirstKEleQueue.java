
import java.util.*;
public class ReverseFirstKEleQueue {
    static class Queue{
        Node head = null;
        Node f = null;
        Node r = null;
        class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        void enQueue(int data){
            Node nNode = new Node(data);
            if (f == null){
                f = nNode;
                r = nNode;
            }else{
                r.next = nNode;
                r = nNode;
            }
        }

        int deQueue(){
            if (f == null){
                System.out.println("UnderFlow");
                return -1;
            }
            int value = f.data;
            f = f.next;
            return value;
        }

        void display(){
            Node temp = f;
            while (temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        void kElement(int k){

        }
        void reverse(int k){
            Node temp = f;
            for (int i =1; i<= k;i++){
                int value = deQueue();
                enQueue(value);
            }
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.display();
        q.reverse(3);
        q.display();
    }
}
