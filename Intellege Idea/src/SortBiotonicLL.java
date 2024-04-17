public class SortBiotonicLL {
    Node head;
    Node tail;
    int size;
    SortBiotonicLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    void addFirst(int data){

        Node nNode = new Node(data);
        Node temp = head;
        if(head == null){
            head = nNode;
            this.tail = nNode;
        }else{
            temp.prev = nNode;
            nNode.next = temp;
            head = nNode;
        }
        size++;
    }
    void addLast(int data){
        Node nNode = new Node(data);
        if(head == null){
            head = nNode;
            this.tail = nNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            nNode.prev = temp;
            temp.next = nNode;
            tail = nNode;
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
    Node merge(Node left,Node right){
        Node result = null;
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        if (left.data <= right.data){
            result =  left;
            result.next = merge(left.next,right);
        }else{
            result = right;
            result.next = merge(left,right.next);
        }

        return result;
    }

    Node divide(Node h){
        if (h == null || h.next == null){
            return h;
        }

        Node current = h.next;
        while (current != null){

            if (current.data < current.prev.data){
                break;
            }
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;


        current = reverse(current);

        Node mergeList = merge(current,h);
        return mergeList;
    }
    Node reverse(Node h){
        if (h == null){
            return h;
        }

        Node curr = h;
        Node prev = null;

        while (curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

        SortBiotonicLL s = new SortBiotonicLL();

        s.addLast(1);
        s.addLast(4);
        s.addLast(5);
        s.addLast(9);
        s.addLast(7);
        s.addLast(3);
        s.addLast(2);

        s.display();
        Node temp = s.divide(s.head);
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }
}
