import java.util.Scanner;

public class Exanple2 {

    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void creation(){

        int n;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Enter Data : ");
            String data = sc.next();

            Node new_Node = new Node(data);

            if(head == null){
                head = new_Node; 
            }else{

                Node temp = head;

                while(temp.next != null){

                    temp = temp.next;
                }
                temp.next = new_Node;
                
            }

            System.out.println("Enter (1) if if want enter data again : ");
            n = sc.nextInt();

        }while(n == 1);
    }

    void display(){

        Node temp = head;

        if(temp == null){
            System.out.println("Link list dos't exist");
        }else{

            while(temp.next != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }

    }
    public static void main(String[] args) {
        
        Exanple2 n = new Exanple2();

        n.creation();
        n.display();


    }
    
}
