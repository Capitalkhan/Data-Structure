public class MirrorTree {
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

            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }

        Node mirrorTreeOfOrignalTree(Node root){
            if (root == null){
                return null;
            }
            Node nNode = new Node(root.data);
            nNode.right = mirrorTreeOfOrignalTree(root.left);
            nNode.left = mirrorTreeOfOrignalTree(root.right);
            return nNode;
        }

    }

    public static void main(String[] args) {

        int[] nodes = {5,3,2,-1,-1,4,-1,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();

        BinaryTree mirrorTree = new BinaryTree();
        Node root2 = mirrorTree.mirrorTreeOfOrignalTree(root);
        mirrorTree.preOrder(root2);

    }
}