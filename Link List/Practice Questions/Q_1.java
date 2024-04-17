import java.util.Scanner;

public class Q_1 {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;

    void creation(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 7; i++){

            System.out.print("Enter Data : ");
            int data = sc.nextInt();

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
        }
    }

    void display(){

        Node temp = head;

        while(temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    void allElements(){

        Node temp = head;
        int count = 0;
        while(temp != null){
            //System.out.println(temp.data+" ");
            temp = temp.next;
            count++;
        }

        System.out.println("All Nodes in LL are : "+count);
    }

    void MaxElement(){

        Node temp = head;
        //temp = temp.next;

        int maxEle = 0;
        while(temp.next != null){

            temp = temp.next;
            if(maxEle < temp.data){
                maxEle = temp.data;
            }

        }

        System.out.println("Maximum alement are : "+maxEle);
    }

    public static void main(String[] args) {
        

        Q_1 n = new Q_1();

        n.creation();
        n.display();
        n.allElements();
        n.MaxElement();
        
    }
    
}