import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>();

        q.offer(21);
        q.offer(12);
        q.offer(43);
        q.offer(35);
        q.offer(25);

        System.out.println(q);
        //System.out.println(q.peek());

        q.poll();
        q.poll();

        System.out.println(q);
    }
    
}