import java.util.Stack;

public class SpecialStack {
    static int min;
    static Stack<Integer> s = new Stack<>();


    static void push(int data) {

        if (s.isEmpty()) {
            min = data;
            s.push(data);
        }else{
            int x = data;
            if (x < min){
                x = 2*x-min;
                min = data;
            }
            s.push(x);
        }
    }

    static int pop(){
        int v = s.peek();
        if (v >= min){
            s.pop();
        }else{
            int x = 2*min-v;
            s.pop();
            min = x;
        }
        return v;
    }
    static int minEle() {
        return min;
    }

    static void display(){
        System.out.println(s);
    }

    public static void main(String[] args) {
        push(4);
        push(2);
        push(7);
        push(1);
        push(6);
        push(3);
        display();

        pop();
        pop();
        pop();
        pop();
        display();
        System.out.println(minEle());

     }


}