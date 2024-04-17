import java.util.LinkedList;
import java.util.Queue;

public class RightView {
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

        // in recursion
        void rightView(Node root){
            indx = 0;
            printRightView(root,1);
        }
        void printRightView(Node root,int level){
            if (root == null){
                return;
            }
            if (indx < level){
                System.out.print(root.data+" ");
                indx = level;
            }

            printRightView(root.right,level+1);
            printRightView(root.left,level+1);

        }

        // in itrative way
        void rightView2(Node root){
            if (root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){

                int n = q.size();
                for (int  i = 0; i<n; i++){
                    Node temp = q.peek();
                    q.remove();

                    if (i == n-1){
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
        int[] nodes = {1,2,4,-1,8,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();

        tree.rightView(root);
        System.out.println();
        tree.rightView2(root);
    }
}