import java.util.Scanner;

public class DeletionExample {
    private int size;
    
    DeletionExample(){
        this.size = 0;
    }

    class sK{

        int data;
        sK  next;

        sK(int data){
            this.data = data;
            this.next= null;
            size++;
        }
    }

    sK head = null;

    void creation(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 7; i++){

            System.out.print("Enter Data : ");
            int d = sc.nextInt();

            sK new_Node = new sK(d);

            if(head == null){
                head = new_Node;
            }
            else{
                
                sK temp = head;

                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = new_Node;
            }
        }
    }

    void display(){

        sK temp = head;

        if(temp == null){
            System.out.println("LL dos'nt exist");
        }else{

            while(temp != null){
                System.out.println(temp.data+" ");
                temp = temp.next;
            }
        }
    }

    void deletion(){

        Scanner sc = new Scanner(System.in);

        
        System.out.println("<<Deletion>>");
        System.out.print("1 for start <> 2 for start <> 3 for start = ");
        int n= sc.nextInt();
        System.out.println();

        switch(n){

            case 1 :
            head = head.next;
            size--;
            break;
            
            case 2 : 

            sK temp2 = head;
            sK ptr = temp2.next;

            while(ptr.next != null){

                temp2 = ptr;
                ptr= ptr.next;
            }
            temp2.next = null;
            size--;
            break;

            case 3 : 

            System.out.print("Enter postion : ");
            int p = sc.nextInt();

            sK temp3 = head;
            sK ptr2 = temp3.next;

            for(int i = 0; i < p-2; i++){

                temp3 = ptr2;
                ptr2 = ptr2.next;
            }
            temp3.next = ptr2.next;
            size--;
            break;

        }
    }

    int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        
        DeletionExample n = new DeletionExample();

        n.creation();
        n.display();
        System.out.println("After Deletion");
        n.deletion();
        n.display();

        System.out.println("Size of LL : "+n.getSize());
    }
    
}
