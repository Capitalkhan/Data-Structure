import java.util.Comparator;
import java.util.PriorityQueue;

public class Priorityqueue {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }

    }
    public static void main(String[] args) {

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  // for reverse the order
        PriorityQueue<Student> pq = new PriorityQueue<>();


        pq.add(new Student("A",3));
        pq.add(new Student("B",6));
        pq.add(new Student("C",2));
        pq.add(new Student("D",9));

        while (!pq.isEmpty()){
            System.out.println(pq.peek().name);
            pq.remove();
        }
    }
}
