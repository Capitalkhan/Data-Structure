public class ReverseQueue {
    static class Queue{
        Node head = null;
        static Node f = null;
        static Node r = null;
         static class Node{
             int data;
             Node next;
             Node(int data){
                 this.data = data;
                 this.next = null;
             }
         }

         void enQueue(int data){
             Node nNode = new Node(data);
             if (f == null){
                 f = nNode;
                 r = nNode;
             }else{
                 r.next = nNode;
                 r = nNode;
             }
         }

         int deQueue(){
             if (f == null){
                 System.out.println("UnderFlow");
                 return -1;
             }
             int value = f.data;
             f = f.next;
             return value;
         }

         void display(){
             Node temp = f;
             while (temp != null){
                 System.out.print(temp.data+" ");
                 temp = temp.next;
             }
             System.out.println();
         }

         Queue reverse(Node temp){
             Queue q2 = new Queue();
             if (temp.next == null){
                 return q2;
             }
             int data = deQueue();
             temp = temp.next;

             reverse(temp);

             if (temp != null){
                 q2.enQueue(data);
             }
             return q2;
         }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(3);
        q.enQueue(47);
        q.enQueue(57);
        q.enQueue(79);
        q.enQueue(2);

        q.display();

        Queue.Node temp = Queue.f;

        Queue rQ = q.reverse(temp);
        rQ.display();
    }
}
