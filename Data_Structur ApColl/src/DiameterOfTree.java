public class DiameterOfTree {
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

//    this method take N square time that lot of time
//    static int height(Node root){
//        if (root == null){
//            return 0;
//        }
//        int leftNode = height(root.left);
//        int rightNode = height(root.right);
//
//        int myHeight = Math.max(leftNode , rightNode)+1;
//        return myHeight;
//    }
//
//    static int diameter(Node root){ // time complexity O(N^2)
//        if (root == null){
//            return 0;
//        }
//        int dam1 = diameter(root.left);
//        int dam2 = diameter(root.right);
//        int dam3 = height(root.left)+height(root.right)+1;
//
//        return Math.max(dam3, Math.max(dam1,dam2));
//    }

    // Another method for finding diameter take O(N) time

    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    static TreeInfo diamter2(Node root){

        if (root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diamter2(root.left);
        TreeInfo right = diamter2(root.right);

        int treeHeight = Math.max(left.ht,right.ht)+1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int treeDiameter = Math.max(Math.max(diam1,diam2), diam3);

        TreeInfo myInfo = new TreeInfo(treeHeight,treeDiameter);
        return myInfo;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buldTree(nodes);

//        System.out.println(diameter(root));

        System.out.println(diamter2(root).diam);
    }

}
