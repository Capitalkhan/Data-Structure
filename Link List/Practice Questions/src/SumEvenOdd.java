public class SumEvenOdd {
    int size;
    Node head;
    SumEvenOdd(){
        this.size = 0;
        this.head = null;
    }

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data){


        Node nNode = new Node(data);
        if(this.head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        ++size;
    }

    void addLast(int data){

        Node nNode = new Node(data);
        if(this.head == null){
            head = nNode;
        }else{
            Node temp = head;

            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = nNode;
        }
        ++size;
    }

    void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void sumEO(){
        Node temp = head;
        int sumEven = 0;
        int sumOdd = 0;

        while (temp != null){
            if(temp.data % 2 == 0){
                sumEven += temp.data;
            }else{
                sumOdd += temp.data;;
            }
            temp = temp.next;
        }

        System.out.println("Sum Even : "+sumEven);
        System.out.println("Sum Odd : "+sumOdd);
    }

    int sumOfPrime(){

        Node temp = head;

        int sP = 0;
        while (temp != null){

            Boolean flag = true;
            for(int i =2; i < (temp.data/2); i++){

                if(temp.data % i == 0){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                sP += temp.data;
            }

            temp = temp.next;
        }

        return sP;
    }


    public static void main(String[] args) {
        SumEvenOdd eo = new SumEvenOdd();

        eo.addLast(2);
        eo.addLast(43);
        eo.addLast(3);
        eo.addLast(65);
        eo.addLast(5);
        eo.addLast(7);
        eo.addLast(9);

        eo.display();

//        eo.sumEO();

        SumEvenOdd sa = new SumEvenOdd();

        sa.addLast(2);
        sa.addLast(32);
        sa.addLast(43);
        sa.addLast(5);
        sa.addLast(6);

        sa.display();

        System.out.println(sa.sumOfPrime());


    }
}
