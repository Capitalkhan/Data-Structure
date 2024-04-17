public class SubTreeOfAnotherTree {
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
    }
    static void preOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    static Boolean isIdentical(Node root,Node subRoot){
        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null){
            return false;
        }

        if (root.data == subRoot.data){
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }

        return false;
    }

    static Boolean isSubTree(Node root, Node subRoot){
        if (subRoot == null){
            return true;
        }
        if (root == null){
            return false;
        }

        if (root.data == subRoot.data){
            if (isIdentical(root,subRoot)){
                return true;
            }
        }

        return isSubTree(root.left,subRoot.left) || isSubTree(root.right,subRoot.right);
    }

    public static void main(String[] args) {

        // Main tree
        int[] nodes = {9, 7, 8, -1, -1, 1, 2, -1, -1, 3, -1, -1, 4,5,-1,-1,6,-1,-1};
        BinaryTree mTree = new BinaryTree();
        Node root = mTree.buldTree(nodes);
//        preOrder(root);


        // sub Tree
        BinaryTree subTree = new BinaryTree();
        int[] subNodes = {1,2,-1,-1,3,-1,-1};
        Node subRoot = subTree.buldTree(subNodes);
//        preOrder(subRoot);
    }
}
