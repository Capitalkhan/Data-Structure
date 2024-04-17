import java.util.Scanner;

public class Single_Creation {

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

        int data,n;
        Scanner sc = new Scanner(System.in);

        //Node new_Node = new Node(43);

        do{
            System.out.println("Enter Data : ");
            data= sc.nextInt();

            Node new_Node = new Node(data);
          
            if(head == null){
                head = new_Node;
            }else{
    
                // new_Node.next = head;
                // head = new_Node;

                System.out.println("Enter 1 insertion For Begning,Enter 2 insertion For last,Enter 3 insertion for specific Location : ");
                int x = sc.nextInt();

                switch(x)
                {

                    case 1 : 
                    new_Node.next = head;
                    head = new_Node;
                    break;


                    case 2 :

                    Node temp = head;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = new_Node;

                    
                    break;


                    case 3 : 
                    System.out.println("Enter Position of the Node : ");
                    int p = sc.nextInt();
                    Node temp2 = head;
                    for(int i = 0; i < p-1; i++){
                        temp2 = temp2.next;
                    }
                    new_Node.next = temp2.next;
                    temp2.next = new_Node;


                    

                }
                
            }

            System.out.println("Do you want to enter More Number in Link List(Press 1) : ");
            n = sc.nextInt();
        }
        while(n == 1);
        


    }

    
    void display(){


        Node temp = head;

        if(temp == null){
            System.out.println("Link List Dos'nt exist");
        }else{
            

            while(!(temp == null)){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }
    
    public static void main(String[] args) {
        
        Single_Creation ll = new Single_Creation();

        ll.creation();
        ll.display();

    }
    
}