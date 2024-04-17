import java.util.ArrayList;

public class Traversals {
    static class Node{
        int  data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        Node buildTree(int[] nodes){
            ++idx;
            if (nodes[idx] == -1){
                return null;
            }

            Node nNode = new Node(nodes[idx]);

            nNode.left = buildTree(nodes);
            nNode.right = buildTree(nodes);

            return nNode;
        }
        void preOrder(Node root){

            if (root == null){
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        void inOrder(Node root){

            if (root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        void postOrder(Node root){

            if (root == null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
//        int[] nodes = {1,2,4,-1,-1,5,6,-1,-1,-1,3,-1,-1};
//        int[] nodes = {4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1};
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
//        tree.preOrder(root);
//        System.out.println();

//        tree.inOrder(root);
//        System.out.println();

        tree.postOrder(root);

    }
}
