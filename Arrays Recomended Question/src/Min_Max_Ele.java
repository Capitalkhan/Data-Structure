public class Min_Max_Ele {
    public static void main(String[] args) {

        int arr[] = {4,7,54,8,9,23,65,3};

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (min > arr[j]){
                    min = arr[j];
                }else if(max < arr[j]){
                    max = arr[j];
                }
            }
        }

        System.out.println("Min : "+min);
        System.out.println("Max : "+max);
    }
}
