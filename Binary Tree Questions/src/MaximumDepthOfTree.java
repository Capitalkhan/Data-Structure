public class MaximumDepthOfTree {
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
        static Node buildTree(int[] nodes){
            indx++;
            if (nodes[indx] == -1){
                return null;
            }

            Node nNode = new Node(nodes[indx]);
            nNode.left = buildTree(nodes);
            nNode.right =  buildTree(nodes);
            return nNode;
        }
        static void preOrder(Node root){
            if (root == null){
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        static int depthOfTree(Node root){

            if (root == null){
                return 0;
            }
            int leftNode = depthOfTree(root.left);
            int rightNode = depthOfTree(root.right);

            int maxDepth = Math.max(leftNode , rightNode)+1;
            return maxDepth;
        }
    }

    public static void main(String[] args) {

        int[] nodes = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println();
        System.out.println(tree.depthOfTree(root));


    }
}
