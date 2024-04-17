import java.util.Scanner;

public class TwoStackInAnArray {
    static class Stack{

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int realSize = 0;

        int[] stack1;
        int[] stack2;
        int st1Length = arr.length/2;

        int st2Length = arr.length-(st1Length);
        int cSize1 = -1;
        int cSize2 = -1;
        Stack(){
            stack1 = new int[st1Length];
            stack2 = new int[st2Length];
        }

        void push(int value,int n){

            if (n == 1){
                if (cSize1 == stack1.length-1){
                    System.out.println("stack 1 OverFlow error");
                    return;
                }else{
                    realSize++;
                    ++cSize1;
                    stack1[cSize1] = value;
                }
            }else{
                if (cSize2 == stack2.length-1){
                    System.out.println("stack 2 OverFlow error");
                }else{
                    realSize++;
                    ++cSize2;
                    stack2[cSize2] = value;
                }
            }
        }

        void pop(){

            System.out.println("Press<1> for pop stack_1");
            System.out.println("Press<2> for pop stack_2");
            System.out.print("Now enter number : ");
            int n = sc.nextInt();
            if (n == 1){
                if (cSize1 == -1){
                    System.out.println("UnderFlow error stack_1");
                }else{
                    realSize--;
                    cSize1--;
                    for (int i =0; i< cSize1; i++){
                        stack1[i] = stack1[i+1];
                    }
                }
            }else{
                if (cSize2 == -1){
                    System.out.println("UnderFlow error stack_2");
                }else{
                    realSize--;
                    cSize2--;
                    for (int i =0; i< cSize2; i++){
                        stack2[i] = stack2[i+1];
                    }
                }
            }
        }

        int peek(){
            System.out.println("Press<1> for peek stack_1");
            System.out.println("Press<2> for peek stack_2");
            System.out.print("Now enter number : ");
            int n = sc.nextInt();

            if (n == 1){
                if (cSize1 == -1){
                    return -1;
                }else{
                    return stack1[cSize1];
                }
            }else{
                if (cSize2 == -1){
                    return -1;
                }else{
                    return stack2[cSize2];
                }
            }
        }

        void display(int selecter){
            if (selecter == 1){
                if (cSize1 == -1){
                    System.out.println("There is not data in stack_1");
                }

                for (int i:stack1) {
                    if (i == 0){
                        break;
                    }
                    System.out.print(i+" ");

                }
                System.out.println();
            }else{
                if (cSize2 == -1){
                    System.out.println("There is not data in stack_2");
                }
                for (int i:stack2) {
                    if (i == 0){
                        break;
                    }
                    System.out.print(i+" ");

                }
            }
        }



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack s = new Stack();

        s.push(5,1);
        s.push(7,1);
        s.push(3,1);
        s.push(9,2);
        s.push(4,2);
        s.push(1,2);
        s.push(2,2);

//        s.display(1);
//        s.display(2);
    }

}
