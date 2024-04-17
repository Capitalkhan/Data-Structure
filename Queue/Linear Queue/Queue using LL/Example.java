import java.util.Scanner;

public class Example{
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head = null;
    Node tail = null;
    Node f = null;
    Node r = null;    
    void enqueue(){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Data : ");
        int data = sc.nextInt();

        Node nNode = new Node(data);

        if(f == null){
            
            f = nNode;
            r = nNode;

        }else{
            // Node temp = head;

            // while(temp != head){
            //     temp = temp.next;
            // }
            r.next = nNode;
            r = nNode;
            
        }
    }

    void dequeqe(){

        
        if(r == null){
            System.out.println("UnderFlow");
        }else{
            f = f.next;
        }
    }

    void display(){

        Node temp = f;
        System.out.println();
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Example q = new Example();

        int num;
        do{
            System.out.print("enter 1 enqueue,enter 2 dequeue,enter 3 display,wana exite press any key : ");
            num = sc.nextInt();

            switch(num){

                case 1 :
                q.enqueue();
                break;

                case 2:
                q.dequeqe();
                break;

                case 3:
                q.display();
                break;

            }


        }while(num >= 1 && num <= 3);
    }
}