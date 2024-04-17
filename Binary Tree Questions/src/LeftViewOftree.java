import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOftree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int indx = -1;

        Node builtTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node nNode = new Node(nodes[indx]);
            nNode.left = builtTree(nodes);
            nNode.right = builtTree(nodes);
            return nNode;
        }

        void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        // in recurtion
        void leftView(Node root){

            indx = 0;
            printLeftView(root,1);

        }

        void printLeftView(Node root,int level){
            if (root == null){
                return;
            }
            if (indx < level){
                System.out.print(root.data+" ");
                indx = level;
            }
            printLeftView(root.left,level+1);
            printLeftView(root.right,level+1);
        }

        // in itrative way

        void printLeftView2(Node root){
            if (root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()){
                int n = q.size();
                for (int i = 1; i <= n; i++){
                    Node temp = q.poll();

                    if (i == 1){
                        System.out.print(temp.data+" ");
                    }

                    if (temp.left != null){
                        q.add(temp.left);
                    }
                    if (temp.right != null){
                        q.add(temp.right);
                    }
                }
            }

        }


    }

    public static void main(String[] args) {

//        int[] nodes = {10,20,40,-1,-1,60,-1,-1,30,-1,-1};
        int[] nodes = {1,2,4,-1,8,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();

        tree.leftView(root);
        System.out.println();
        tree.printLeftView2(root);

    }
}