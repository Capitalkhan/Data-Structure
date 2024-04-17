import java.util.ArrayList;
import java.util.List;

public class Arraylist {
    public static void main(String[] args) {
        
        List<Integer> c = new ArrayList<>();

        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);

        System.out.println(c);
        //System.out.println(c.get(4));
        
        //c.clear();

        //c.remove(0);


        // c.set(0, 7);
        
        
        System.out.println(c.contains(7));
        System.out.println(c);


    }
    
}