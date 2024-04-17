import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priority_Queue {
    public static void main(String[] args) {
        
        Queue <Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        q.offer(21);
        q.offer(23);
        q.offer(41);
        q.offer(31);
        q.offer(41);

        System.out.println(q);
        q.poll();
        System.out.println(q);
    }
    
}
