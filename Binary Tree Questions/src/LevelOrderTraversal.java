import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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
        void levelOrderDisplayTree(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            if (root == null){
                return;
            }

            while (!q.isEmpty()){
                Node nNode = q.remove();
                if (nNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(nNode.data+" ");
                    if (nNode.left != null){
                        q.add(nNode.left);
                    }
                    if (nNode.right != null){
                        q.add(nNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();
        tree.levelOrderDisplayTree(root);
    }
}
