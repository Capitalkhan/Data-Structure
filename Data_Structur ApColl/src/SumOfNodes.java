public class SumOfNodes {
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

        static Node buildTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node nNode = new Node(nodes[indx]);
            nNode.left = buildTree(nodes);
            nNode.right = buildTree(nodes);
            return nNode;
        }
    }
    static int sumOfNode(Node root){
        if (root == null){
            return 0;
        }

        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(sumOfNode(root));
    }
}
