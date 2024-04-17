public class LeafAtSameLevel {
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
        static int levelOfLeaf = 0;
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
        Boolean isLeafSameLevel(Node root,int level){
            if (root == null){
                return true;
            }

            if (root.left == null && root.right == null){
                if (levelOfLeaf == 0){
                    levelOfLeaf = level;
                    return true;
                }
                return levelOfLeaf == level;
            }
            return isLeafSameLevel(root.left,level+1)&& isLeafSameLevel(root.right,level+1);
        }

    }

    public static void main(String[] args) {

        int[] nodes = {10,20,10,-1,-1,15,-1,-1,30,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes);
        tree.preOrder(root);
        System.out.println();
        System.out.println(tree.isLeafSameLevel(root,1));
    }
}