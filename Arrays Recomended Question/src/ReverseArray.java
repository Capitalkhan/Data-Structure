public class ReverseArray {
    public static void main(String[] args) {

        int arr[] = {4,7,54,8,9,23,65,3};

        int count = arr.length-1;
        int value = 0;
        for (int i =0; i < arr.length; i++){
            value = arr[i];
            arr[i] = arr[count];
            arr[count] = value;
            count--;
            if (i == count){
                break;
            }
        }

        for (int i: arr){
            System.out.print(i+" ");
        }
    }
}
