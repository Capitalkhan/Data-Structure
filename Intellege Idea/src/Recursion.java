public class Recursion {
    static int calcpower(int x,int n){


        if(n==0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        int xPower1 = calcpower(x,n-1);
        int xPower2 = x * xPower1;
        return  xPower2;
    }

    public static void print(int num){

        if(num == 6){
            return;
        }

        System.out.println(num);
        print(++num);

    }

    public static int sum(int f,int n,int sum){

        if(f == n){
            sum+= f;
            return sum;
        }

        sum += f;
        int x = sum(++f,n,sum);
//        System.out.println(f);

        return x;


    }
    static int factorial(int num){

        if(num ==1){
            return 1;
        }

        int n = factorial(num-1);
//        System.out.println(n);
        n *= num;
//        System.out.println(num);
        return n;

    }

//    static void fibonacci(int first,int second,int num,int c){
//        if(c == num){
//            return;
//        }
//        int s = first+second;
//        c = s;
//        System.out.println(s);
//        fibonacci(second,s,num,c);
//    }

    static void fibonacci(int a,int b,int n){
        if(n == 0){
            return;
        }
        int s = a+b;
        // System.out.print(a+" "+b+" "+s);
        System.out.println();
        fibonacci(b,s,n-1);
    }
    public static void main(String[] args) {
        //Recursion r = new Recursion();

        //int n = 0;
        //print(1);

        //System.out.println(sum(1,7,0));
        //System.out.println(factorial(5));
        System.out.println(0);
        System.out.println(1);
        fibonacci(0,1,7-2);

        // System.out.println(calcpower(2,5));

    }
}
