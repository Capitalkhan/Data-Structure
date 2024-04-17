import java.util.Stack;

public class StackPermutation {

    static boolean isPossible(int[] arr1,int[] arr2){
        Stack<Integer> s = new Stack<>();

        int j = 0; // counter of arr2

        for (int i = 0; i< arr1.length;i++){
            s.push(arr1[i]);

            while (!s.isEmpty() && s.peek() == arr2[j]){
                s.pop();
                j++;
            }
        }

        if (s.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // permutation is possible
//        int[] arr1 = {1,2,3};
//        int[] arr2 = {2,1,3};

        // permutation is not possible

        int arr1[] = {1,2,3};
        int arr2[] = {3,1,2};

        System.out.println(isPossible(arr1,arr2));

    }
}