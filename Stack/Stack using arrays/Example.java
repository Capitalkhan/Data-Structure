import java.util.Scanner;

class stack{
    int n = 7;
    int[] arr = new int[n];
    int top = -1;

    void push(Scanner sc){

        if(top == n-1){
            System.out.println("OverFlow");
        }else{
            top++;
            System.out.print("Array ["+top+"] = ");
            arr[top] = sc.nextInt(); 
        }
    }
    void pop(){

        if(top < 0){
            System.out.println("UnderFlow");
        }else{
            arr[top] = 0;
            --top;
        }
    }

    void display(){
        System.out.println();
        for(int i = 0; i <= this.top; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}


public class Example{
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        stack s = new stack();
        int num;
        do{
            System.out.print("Enter 1 Push,Enter 2 pop,Enter 3 display, Wana Exite Press any key : ");
            num = sc.nextInt();

            if(num == 1){
                s.push(sc);
            }else if(num == 2){
                s.pop();
            }else if(num == 3){
                s.display();
            }
        }while(num >= 1 && num <= 3);


   }     
}