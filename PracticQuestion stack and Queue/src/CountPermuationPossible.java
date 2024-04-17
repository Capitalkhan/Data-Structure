import java.util.ListIterator;
import java.util.Stack;

public class CountPermuationPossible {

    static void insertEle(Stack<Integer> s,int x){
        if (s.isEmpty() || s.peek() < x){
            s.push(x);
            return;
        }

        int temp = s.pop();

        insertEle(s,x);

        s.push(temp);
    }

    static void sortStack(Stack<Integer> s){

        if (!s.isEmpty()){
            int x = s.pop();

            sortStack(s);

            insertEle(s,x);
        }
    }

    static void printStack(Stack<Integer> s){
        ListIterator<Integer> it = s.listIterator();

        while (it.hasNext()){
            it.next();
        }

        while (it.hasPrevious()){
            System.out.print(it.previous()+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        printStack(s);
        System.out.println("after");
        sortStack(s);
        printStack(s);

    }
}

