import java.util.Scanner;

public class Example {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    int top = -1;

    void push(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Data : ");
        int data = sc.nextInt();

        Node nNode = new Node(data);

        if(head == null){
            top++;
            head = nNode;
        }else{
            top++;
            nNode.next = head;
            head = nNode;
        }

        
        
    }

    void pop(){

        if(head == null){
            System.out.println("UnderFlow");
        }else{
            head = head.next;
            --top;
        }
    }
    

    void display(){

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Example s = new Example();
        int num;
        do{
            System.out.print("Enter 1 push,Enter 2 pop,Enter 3 display,Wana Exite Press any key : ");
            num = sc.nextInt();

            switch(num){

                case 1 :
                s.push();
                break;

                case 2 :
                s.pop();
                break;

                case 3 : 
                s.display();
                break;


            }
        }while(num >= 1 && num <= 3);
    }
}