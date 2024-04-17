public class UniqueEle {
    int size;
    Node head;
    UniqueEle(){
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

    void uniqueElements(){
        Node temp = head;
        while (temp != null){

            Node ptr = this.head;

            int num = temp.data;

            int chek = 0;
            while (ptr != null){
                if(ptr.data == num){
                    ++chek;
                }
                ptr = ptr.next;
            }
            if(chek == 1){
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        UniqueEle un = new UniqueEle();

        un.addLast(3);
        un.addLast(4);
        un.addLast(3);
        un.addLast(7);
        un.addLast(3);
        un.addLast(7);
        un.addLast(2);
        un.addLast(2);
        un.addLast(5);
        un.addLast(7);

        un.display();

        un.uniqueElements();
    }
}
