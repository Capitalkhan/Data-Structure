
import java.util.*;

public class Collection_Framework {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.addFirst("this");
        list.addLast("is");
        list.addLast("Black");
        list.addLast("World");
        list.addFirst("!");

        System.out.println(list);

        System.out.println("Size are : "+list.size());


        list.removeFirst();
        list.removeLast();



        list.remove(1);
        System.out.println();
        System.out.println(list);

        System.out.println("Reverse LL using collection framework");
    }
}
