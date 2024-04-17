public class Subtract {
    Node head;
    int size;
    Subtract(){
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

    void subList(Node h1,Node h2){

        String str1 = "";
        String str2 = "";

        while (h1 != null){
            str1 += String.valueOf(h1.data);
            h1 = h1.next;
        }
        while (h2 != null){
            str2 += String.valueOf(h2.data);
            h2 = h2.next;
        }

        int val = 0;
        if (Integer.parseInt(str1) < Integer.parseInt(str2)){
            val = Integer.parseInt(str2) - Integer.parseInt(str1);
        }else{
            val = Integer.parseInt(str1) - Integer.parseInt(str2);
        }

        str1 = String.valueOf(val);
        for (int i = 0; i<str1.length(); i++){
            char c = str1.charAt(i);
            addLast(Integer.parseInt(String.valueOf(c)));
        }

    }

    public static void main(String[] args) {

        Subtract s1 = new Subtract();

        s1.addLast(7);
        s1.addLast(8);
        s1.addLast(6);
        s1.display();

        Subtract s2 = new Subtract();

        s2.addLast(7);
        s2.addLast(8);
        s2.addLast(9);
        s2.display();

        Subtract s3 = new Subtract();

        s3.subList(s1.head,s2.head);
        s3.display();
    }
}
