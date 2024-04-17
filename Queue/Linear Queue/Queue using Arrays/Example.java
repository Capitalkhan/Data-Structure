import java.util.Scanner;

class Queue{
    int n = 7;
    int[] arr = new int[n];
    int front = -1,rear = -1;


    void enQueue(Scanner sc){

        if(this.rear == n-1){
            System.out.println("OverFlow");
        }else{
            rear++;
            System.out.println("Array["+rear+"] = ");
            this.arr[rear] = sc.nextInt();

            if(rear == 0){
                front = 0;
            }
        }
    }

    void deQueue(){


        if(this.rear == -1){
            System.out.println("UnderFlow");
        }else{
            arr[this.rear] = 0;
            front++;
        }
    }

    void display(){

        for(int i = front; i <= rear; i++){
            System.out.print(arr[i]+" ");
        }
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
                q.enQueue(sc);
                break;

                case 2 : 
                q.deQueue();
                break;


                case 3 : 
                q.display();
                break;


            }
        }while(num >= 1 && num <= 3);
    }
    
}