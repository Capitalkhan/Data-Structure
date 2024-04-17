import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;
        Node builtTree(int[] nodes){
            indx++;
            if (nodes[indx] == -1){
                return null;
            }
            Node nNode = new Node(nodes[indx]);
            nNode.left = builtTree(nodes);
            nNode.right = builtTree(nodes);
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

        void levelOrder(Node root){
            Queue<Node> q = new LinkedList<>();
            if (root == null){
                return;
            }
            q.add(root);
            q.add(null);

            while (!q.isEmpty()){
                Node cNode = q.remove();
                if (cNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(cNode.data+" ");
                    if (cNode.left != null){
                        q.add(cNode.left);
                    }
                    if (cNode.right != null){
                        q.add(cNode.right);
                    }
                }
            }
        }

        public void reverseLevelOrder(Node root){
            Stack<Integer> s = new Stack<>();
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                Node cNode = q.poll();
                s.add(cNode.data);
                if (cNode.right != null){
                    q.add(cNode.right);
                }
                if (cNode.left != null){
                    q.add(cNode.left);
                }
            }
            while (!s.isEmpty()){
                System.out.print(s.pop()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] nodes = {10,20,40,-1,-1,60,-1,-1,30,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println();
        tree.reverseLevelOrder(root);

    }
}
