public class CountTotalNode {
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

        static Node buldTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node nNode = new Node(nodes[indx]);
            nNode.left = buldTree(nodes);
            nNode.right = buldTree(nodes);
            return nNode;
        }

        static int numOfNode(Node root){
            if (root == null){
                return 0;
            }

            int leftNode = numOfNode(root.left);
            int rightNode = numOfNode(root.right);

            return leftNode+rightNode+1;
        }

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buldTree(nodes);

        System.out.println(tree.numOfNode(root));
    }
}