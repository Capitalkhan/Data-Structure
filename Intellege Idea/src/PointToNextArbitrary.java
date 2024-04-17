public class PointToNextArbitrary {
    Node head;
    int size;
    PointToNextArbitrary(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        int data;
        Node next;
        Node arbit;

        Node(int data){
            this.data = data;
            this.next = null;
            this.arbit = null;
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

    void display(Node nextHead,Node arbitHead){



        System.out.println("Node as next");
        while(nextHead != null){
            System.out.print(nextHead.data+" ");
            nextHead = nextHead.next;
        }
        System.out.println();
        System.out.println("Node as arbit");

        while(arbitHead != null){
            System.out.print(arbitHead.data+" ");
            arbitHead = arbitHead.arbit;
        }
        System.out.println();
    }


    Node pointOrbitToMax(Node start){

        Node temp = start;
        while (temp != null){
            temp.arbit = temp.next;
            temp = temp.next;
        }

        return mergeSort(start); // it sort link list as orbit

    }
    Node mergeSort(Node temp){
        if (temp == null || temp.arbit == null){
            return temp;
        }

        Node middle = getMiddle(temp);
        Node nextOfMiddle = middle.arbit;

        middle.arbit = null;

        Node left = mergeSort(temp);
        Node right = mergeSort(nextOfMiddle);

        Node sortList = merge(left,right);
        return sortList;
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
            result = left;
            result.arbit = merge(left.arbit,right);
        }else{
            result = right;
            result.arbit = merge(left,right.arbit);
        }
        return result;
    }
    Node getMiddle(Node temp){
        if (temp == null){
            return temp;
        }

        Node hare = temp;
        Node turtle = temp;

        while (hare.arbit != null && hare.arbit.arbit != null){
            turtle = turtle.arbit;
            hare = hare.arbit.arbit;
        }
        return turtle;
    }

    public static void main(String[] args) {
        PointToNextArbitrary ll = new PointToNextArbitrary();
        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(2);
        ll.addLast(3);

        Node arbitHead = ll.pointOrbitToMax(ll.head);
        ll.display(ll.head,arbitHead);

    }

}
