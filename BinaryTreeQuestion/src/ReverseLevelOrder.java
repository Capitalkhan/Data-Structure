import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
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

        void levelOrder(Node root){
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while (!q.isEmpty()){
                Node cNode = q.poll();

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

        void displayReverseLevelOrder(Node root){
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

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        tree.levelOrder(root);
        System.out.println();
        tree.displayReverseLevelOrder(root);

    }
}
