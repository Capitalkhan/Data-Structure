import java.util.Scanner;

public class Q_2 {
    static class Node{
        
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void creation(Scanner sc){

        int num;

        do{
            System.out.print("Enter data : ");
            int data = sc.nextInt();

            Node nNode = new Node(data);

            if(head == null){
                head = nNode;  
            }else{

                nNode.next = head;
                head = nNode;
            }

            System.out.print("Enter again press 1 : ");
            num = sc.nextInt();
        }while(num ==1);
    }

    void display(){

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    void lastELe(int n){

        Node temp = head;

        int size= 0;

        while(temp != null){
            size++;
            temp = temp.next;
            
        }

        int x = (size-n)+1;
        
        Node temp1 = head;
        for(int  i =0; i < x-1; i++){
            temp1 = temp1.next;
        }
        System.out.println("nth element are :  "+temp1.data);
        
        Node temp2 = head;

        int prev = size-n;
        
        for(int i = 1; i < prev; i++){

            temp2 = temp2.next;
            
        }
        temp2.next = temp2.next.next;


    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Q_2 q = new Q_2();

        q.creation(sc);
        System.out.println();
        q.display();
        System.out.println();
        System.out.println("After");

        System.out.print("Enter N element : ");
        int n = sc.nextInt();

        q.lastELe(n);
        System.out.println();
        q.display();
    }


    
}
