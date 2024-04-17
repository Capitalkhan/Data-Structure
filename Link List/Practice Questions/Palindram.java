import java.util.Scanner;

public class Palindram {
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

    Boolean plaindram(){

        Node temp = head;

        int size = 0;
        while(temp.next != null){
            size++;
        }

        while(size != 0){
            Node temp2 = head;
            while(size != 0){
                temp2 = temp2.next;
                size--;    
            }
            size--;

        }
    }
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        Q_2 q = new Q_2();

        q.creation(sc);
        System.out.println();
        q.display();
        System.out.println();

    }
    
}
