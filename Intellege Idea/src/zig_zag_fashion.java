public class zig_zag_fashion {
    Node head;
    int size;
    zig_zag_fashion(){
        this.head = null;
        this.size = 0;
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
        if(head == null){
            head = nNode;
        }else{
            nNode.next = head;
            head = nNode;
        }
        size++;
    }
    void addLast(int data){
        Node nNode = new Node(data);
        if(head == null){
            head = nNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = nNode;
        }
        size++;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void zigZagList(){

//        int value = 0;
//        Boolean flag = true;
//        Node temp = head;
//        while (temp.next != null && temp != null){
//            if (flag == true){
//                if (temp.data > temp.next.data){
//                    value = temp.data;
//                    temp.data = temp.next.data;
//                    temp.next.data = value;
//                }
//            }else{
//                if (temp.data < temp.next.data){
//                    value = temp.data;
//                    temp.data = temp.next.data;
//                    temp.next.data = value;
//                }
//            }
//            temp = temp.next;
//            flag = !flag;
//        }

    }

    public static void main(String[] args) {

        zig_zag_fashion f = new zig_zag_fashion();

        f.addLast(11);
        f.addLast(15);
        f.addLast(20);
        f.addLast(5);
        f.addLast(10);
        f.addLast(10);
        f.addLast(1);

        f.display();
        f.zigZagList();
        f.display();
    }


}
