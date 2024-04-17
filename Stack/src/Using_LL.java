public class Using_LL {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        static Node head;
        static int size;

        boolean isEmpty(){
            return head == null;
        }

        void push(int data){
            ++size;
            Node nNode = new Node(data);

            if (head == null){
                head = nNode;
            }else{
                nNode.next = head;
                head = nNode;
            }
        }

        int pop(){
            if (size == 0){
                return -1;
            }
            --size;
            int temp = head.data;
            head = head.next;
            return temp;
        }

        int peek(){
            if (size == 0){
                return -1;
            }
            return head.data;
        }

        void display(){
            Node temp = head;
            while (temp!= null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(4);
        s.push(7);
        s.push(3);
        s.push(2);
        s.push(9);
        s.push(7);
        s.display();
        System.out.println(s.pop());
        System.out.println(s.peek());
        s.display();

    }
}
