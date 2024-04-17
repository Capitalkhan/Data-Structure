import java.util.Scanner;

class   Queue{
    int n = 4;
    int[] arr = new int[n];
    int r = -1;
    int f = -1;

    void enqqueue(Scanner sc){

        if(f == (r+1)%n){
            System.out.println("OverFlow");
        }else{

            System.out.print("Enter Data : ");
            int i = sc.nextInt();

            if(r == -1){
                r = 0;f = 0;
                arr[r] = i;
            }else{
                r = (r+1)%n;
                arr[r] = i;
            }
            
        }
    }

    void dequeue(){

        if(r ==-1 && f ==-1 || f == r){
            System.out.println("UnderFlow condition");
        }else{
            arr[f] = 0;
            f = (f+1)%n;
        }
    }

    void display(){

        System.out.println();
        int i;
        for(i = f; i != r; i=(i+1)%n){

            System.out.print(arr[i]+" ");
        }
        System.out.print(arr[i]);
        System.out.println();
    }
}



public class Example {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num;

        Queue q = new Queue();
        do{
            System.out.print("Enter 1 EnQueue,Enter 2 DeQueue,Enter 3 Display,wana exite press any key : ");
            num = sc.nextInt();

            switch(num){

                case 1 :
                q.enqqueue(sc);
                break;

                case 2 : 
                q.dequeue();
                break;


                case 3 : 
                q.display();
                break;


            }
        }while(num >= 1 && num <= 3);
    }


}
    
