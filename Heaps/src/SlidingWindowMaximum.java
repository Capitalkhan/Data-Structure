import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair> {
        int val;
        int indx;
        Pair(int val,int indx){
            this.val = val;
            this.indx = indx;
        }

        public int compareTo(Pair p2){
            // ascending
//            return this.val - p2.val;
            // descending
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) { // O(nlogk)

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3; // size of window
        int res[] = new int[arr.length-k+1];


        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st Window
        for (int i = 0; i<k; i++){
            pq.add(new Pair(arr[i],i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i<arr.length; i++){

            while (pq.size() > 0 && pq.peek().indx <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        //print result
        for (int i = 0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
