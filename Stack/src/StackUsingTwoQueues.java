import java.util.*;
public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int size = 0;

    void push(int value){
        q1.add(value);
        size++;
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop(){

        if(size == 0 || q1.isEmpty()){
            return -1;
        }
        while (q1.size() != 1){
            q2.add(q1.remove());
        }
        size--;
        int returnValue = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return returnValue;
    }
    void display(){
        System.out.println(q1);
    }

    public static void main(String[] args) {

        StackUsingTwoQueues sqq = new StackUsingTwoQueues();

        sqq.push(4);
        sqq.push(8);
        sqq.push(6);
        sqq.push(2);
        sqq.push(9);

        sqq.display();
        System.out.println();
        System.out.println(sqq.pop());

        sqq.display();

    }

}
