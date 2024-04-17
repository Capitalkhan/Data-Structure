import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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
        Node invertTreeUsingRecurtion(Node root){
            if (root == null){
                return null;
            }
            Node temp = root.left;
            root.left = invertTreeUsingRecurtion(root.right);
            root.right = invertTreeUsingRecurtion(temp);
            return root;
        }
        Node invertTreeUsingIteration(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                Node nNode = q.poll();
                if (nNode != null){
                    q.add(nNode.left);
                    q.add(nNode.right);
                    Node temp = nNode.left;
                    nNode.left = nNode.right;
                    nNode.right = temp;
                }
            }
            return root;
        }


    }

    public static void main(String[] args) {
        int[] nodes = {4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1};
//        int[] nodes = {2,1,-1,-1,3,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();
//        tree.invertTreeUsingRecurtion(root);
        tree.invertTreeUsingIteration(root);
        tree.preOrder(root);



    }
}
