import java.util.ArrayList;

public class CreatingHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){ // O(logn)
            // add the last index
            arr.add(data);

            int x = arr.size()-1; // x is child
            int par = (x-1)/2; // parent index

            // this is min heap
            while (arr.get(x) < arr.get(par)){ // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }

        }

        public void heapify(int i){

            // these are indexes
            int left = 2*i+1;
            int right = 2*i+2;
            int minidx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minidx)){
                minidx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minidx)){
                minidx = right;
            }

            if (minidx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);

                heapify(minidx);
            }

        }
        public int remove(){
            int data = arr.get(0);

            // step : 1 = swap first & last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

//            step: 2 = delete the heap
            arr.remove(arr.size()-1);

//            step: 3 = set heap
            heapify(0);
            return data;
        }


        public int peek(){
            return arr.get(0);
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }

    }
    public static void main(String[] args) {
        // heap as an arraylist
        // finding child
        // left = 2i+1 (i is index)
        // right = 2i+2
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

//        System.out.println(h.remove());
//        System.out.println();
        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }

    }
}
