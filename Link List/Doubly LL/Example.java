import java.util.Scanner;

public class Example {
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

    void creation(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 7; i++){
            System.out.print("Enter Data : ");
            int data = sc.nextInt();

            Node new_Node = new Node(data);

            if(head == null){
                head = new_Node;
                tail = new_Node;
                //new_Node.prev = head;

            }
            else{

                

                    tail.next = new_Node;
                    new_Node.prev = tail;
                    tail = new_Node;
                    

                // System.out.print("Enter 1 End, Enter 2 start, Enter 3 specific Location");
                // int num = sc.nextInt();

                // switch(num){

                //     case 1 : 
                //     Node temp = head;

                //     while(temp.next != null){
                //         temp = temp.next;
                //     }
                //     new_Node.prev = temp;
                //     temp.next = new_Node;
                //     tail = new_Node;
                //     break;


                //     case 2 :
                    
                //     new_Node.next = head;
                //     head.prev = new_Node;
                //     head = new_Node;
                //     break;
                    
                //     case 3 :
                    
                //     System.out.print("Enter Position : ");
                //     int p = sc.nextInt();

                //     Node temp2 = head;

                //     for(int j = 1; j < p; j++){
                //         temp2 = temp2.next;
                //     }
                //     new_Node.next = temp2.next;
                //     temp2.next = new_Node;
                //     new_Node.prev = temp2;
                //     break;
                // }
            }
            
        }
    }
    void display(){

        Node temp = head;
        if(temp == null){
            System.out.println("Dos'nt exist");
        }else{

            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    void deletion(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1 start, Enter 2 end, Enter 3 specific Location");
        int num = sc.nextInt();

        switch(num){

            case 1 : 

            head = head.next;
            head.prev = null;
            break;

            case 2 : 

            Node temp = tail;
            temp = temp.prev;
            temp.next = null;
            // Node temp = head;
            // Node ptr = temp.next;

            // while(ptr.next != null){
            //     temp = ptr;
            //     ptr = ptr.next;
            // }
            // temp.next = null;
            // tail = temp;
            break;

            case 3 : 

            System.out.print("Enter Position : ");
            int p = sc.nextInt();

            Node temp2 = head;
            Node ptr2 = temp2.next;

            for(int i = 1;  i< p-1; i++){

                temp2 = ptr2;
                ptr2 = ptr2.next;
            }
            temp2.next=ptr2.next;
            ptr2.next.prev=temp2;
            break;



        }

    }

    public static void main(String[] args) {
        
        Example n = new Example();

        n.creation();
        n.display();
        System.out.println();
        n.deletion();
        n.display();
    }
    
}