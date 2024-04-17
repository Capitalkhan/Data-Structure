import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {
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
        static Node buldTree(int[] nodes){
            indx++;
            if (nodes[indx] == -1){
                return null;
            }
            Node nNode = new Node(nodes[indx]);
            nNode.left = buldTree(nodes);
            nNode.right = buldTree(nodes);
            return nNode;
        }
        static void preOrderTraversal(Node root){ // time complesity O(n)
            if (root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        static void inOrderTraversal(Node root){ // time complesity O(n)
            if (root == null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
        static void postOrderTraversal(Node root){ // time complesity O(n)
            if (root == null){
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");

        }
        static void levelOrderTraversal(Node root){ // time complesity O(n)
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if (currNode.left != null){
                        q.add(currNode.left);
                    }
                    if (currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buldTree(nodes);
//        System.out.println(root.data);
//        tree.preOrderTraversal(root);
//        System.out.println();
//        tree.inOrderTraversal(root);
//        tree.postOrderTraversal(root);
        tree.levelOrderTraversal(root);
    }
}

