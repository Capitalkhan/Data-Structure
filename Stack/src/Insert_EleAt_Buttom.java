public class Insert_EleAt_Buttom {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static class Stack {
        static Node head;
        static int size;

        static Boolean isEmpty() {

            return head == null;
        }

        static void push(int data) {
            ++size;
            Node nNode = new Node(data);

            if (head == null) {
                head = nNode;
                return;
            }
            nNode.next = head;
            head = nNode;
        }

        static int pop() {
            if (isEmpty()) {
                return -1;
            }
            --size;
            int top = head.data;
            head = head.next;
            return top;
        }

        static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        void display(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data+" ");
                temp= temp.next;
            }
            System.out.println();
        }
        static void insertionButtom(int ele){
//            if(isEmpty()){
//                push(ele);
//                return;
//            }
//            int a = pop();
//            insertionButtom(ele); // this is called recursion
//            push(a);

        }

    }

    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(4);
        s.push(6);
        s.push(3);
        s.push(2);

        s.display();
        s.insertionButtom(7);
        s.display();

    }
}