import java.util.ArrayList;

public class DeletingHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while (arr.get(x) < arr.get(par)){
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }
        private void heapify(int i){ // O(logn)
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
                arr.set(minidx, temp);

                // if heap child is  upset through this swap then we also call for child
                heapify(minidx);
            }
        }
        public int remove(){ // O(logn)
            int data = arr.get(0);


            // step:1 - swap first to last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            // step:2 - remove the last index
            arr.remove(arr.size()-1);

            // step:3 - fix the heap in max heap
            heapify(0);
            return data;

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        // step:1 = replace first node to last node (because we delete first node from last)
        // step:2 = remove last node
        // step:3 = fix the heap (through heapify method)

        Heap h = new Heap();

    }
}
