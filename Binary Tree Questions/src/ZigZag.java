import java.util.Stack;

public class ZigZag {
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

        void printZigZagOfTree(Node root){
            if (root == null){
                return;
            }
            Stack<Node> curLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();

            curLevel.push(root);
            Boolean leftToRight = true;

            while (!curLevel.isEmpty()){
                Node nNode = curLevel.peek();
                curLevel.pop();

                System.out.print(nNode.data+" ");
                if (leftToRight){
                    if (nNode.left != null){
                        curLevel.push(nNode.left);
                    }
                    if (nNode.right != null){
                        curLevel.push(nNode.right);
                    }
                }else{
                    if (nNode.left != null){
                        nextLevel.push(nNode.left);
                    }
                    if (nNode.right != null){
                        nextLevel.push(nNode.right);
                    }
                }

                if (curLevel.isEmpty()){

                    leftToRight = !leftToRight;

                    Stack<Node> temp = curLevel;
                    curLevel = nextLevel;
                    nextLevel = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nodes = {7,9,8,10,-1,-1,9,-1,-1,8,-1,-1,7,6,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();
        tree.printZigZagOfTree(root);
    }
}

