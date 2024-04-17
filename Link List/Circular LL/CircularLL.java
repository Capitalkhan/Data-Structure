import java.util.Scanner;


public class CircularLL {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

        Node head = null;
        Node tail = null;

    }

    Node head = null;
    Node tail = null;


    void creation(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 7;i++){

            System.out.print("Enter Data : ");
            int data = sc.nextInt();

            Node new_Node = new Node(data);

            if(head == null){
                
                head = new_Node;
                tail = new_Node;
                new_Node.next = head;

            }else{
                //Insertion in begning
                // new_Node.next = head;
                // head = new_Node;
                // tail.next = head;

                System.out.print("Enter 1 start, Enter 2 End, Enter 3 specific Position = ");
                int n = sc.nextInt();

                switch(n){

                    case 1 : 

                    new_Node.next = head;
                    head = new_Node;
                    break;

                    case 2 : 

                    //Node temp1 = head;
                    tail.next = new_Node;
                    tail = new_Node;
                    new_Node.next = head;
                    break;

                    case 3 : 

                    

                    System.out.print("Enter Position : ");
                    int p = sc.nextInt();

                    Node temp = head;
                    for(int j = 0; j < p-1; j++){

                        temp = temp.next;
                    }
                    new_Node.next = temp.next;
                    temp.next = new_Node;
                    break;

                }
            }

        }
    }

    void display(){

        Node temp = head;
        if(head == null){
            System.out.println("LL dos not exist");
        }else{

            
            do
            {

                System.out.print(temp.data+" ");
                temp = temp.next;

            }while(temp != head);
        }
    }


    void deletion(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1 start, Enter 2 End, Enter 3 specific Position = ");
        int n = sc.nextInt();

        switch(n){

            case 1 :
           // Node temp = head;
            head = head.next;
            tail.next = head;
            break;

            case 2 :

            Node temp = head;
            Node ptr = temp.next;

            while(ptr.next != head){
                temp = ptr;
                ptr = ptr.next;
            }
            tail = temp;
            temp.next = head;
            break;

            case 3 : 

            System.out.println("Enter Psotion : ");
            int p = sc.nextInt();

            Node temp2 = head;
            Node ptr2 = temp2.next;

            for(int i = 1; i<p-1; i++){
                temp2 = ptr2;
                ptr2 = ptr2.next;
            }
            temp2.next= ptr2.next;

            
            break;
        }

    }

    
    public static void main(String[] args) {
        
        CircularLL n = new CircularLL();

        n.creation();
        n.display();
        System.out.println("After");
        n.deletion();
        n.display();

    }
    
}