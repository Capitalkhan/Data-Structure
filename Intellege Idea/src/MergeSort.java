public class MergeSort {
    Node head;
    int size;
    MergeSort(){
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

    Node sortAndMerge(Node left,Node right){

        Node temp = null;
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

            if (left.data <= right.data){
                temp = left;
                temp.next = sortAndMerge(left.next,right);
            }else{
                temp = right;
                temp.next = sortAndMerge(left,right.next);
            }

        return temp;
    }

    Node mergeSort(Node h){
        if (h == null || h.next == null){
            return h;
        }

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);
        Node sortedList = sortAndMerge(left,right);
        return sortedList;
    }

    Node getMiddle(Node h){
        if (h == null){
            return h;
        }

        Node hare = h;
        Node turtle = h;

        while (hare.next != null && hare.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }

    public static void main(String[] args) {

        MergeSort ms = new MergeSort();

        ms.addLast(5);
        ms.addLast(7);
        ms.addLast(2);
        ms.addLast(1);
        ms.addLast(9);

        ms.display();
        Node sort = ms.mergeSort(ms.head);

        while(sort != null){
            System.out.print(sort.data+" ");
            sort = sort.next;
        }
        System.out.println();

    }
}
