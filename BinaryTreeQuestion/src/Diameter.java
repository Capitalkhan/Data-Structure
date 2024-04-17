public class Diameter {
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
        int treeHeight(Node root){
            if (root == null){
                return 0;
            }

            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);

            return Math.max(leftHeight,rightHeight)+1;
        }
        // 0(n^2)
        // take loot of time
        int treeDiameterApproach1(Node root){
            if (root == null){
                return 0;
            }

            int leftDiameter = treeDiameterApproach1(root.left);
            int rightDiameter = treeDiameterApproach1(root.right);
            int rootHeight = treeHeight(root.left) + treeHeight(root.right) +1;


            return Math.max(rootHeight, Math.max(leftDiameter,rightDiameter));
        }

        // tree info class for approach 2
        static class TreeInfo{
            int ht;
            int diam;
            TreeInfo(int ht,int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }
        // 0(n)
        // that best
        public TreeInfo treeDiameterApproach2(Node root){
            if (root == null){
                return new TreeInfo(0,0);
            }

            // first we take info of left and right child
            TreeInfo left = treeDiameterApproach2(root.left);
            TreeInfo right = treeDiameterApproach2(root.right);

            // now we take hight of tree
            int myHeight = Math.max(left.ht, right.ht)+1;

            // now we take diameter of tree as approach 1
            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht+ right.ht+1;

            int myDiam = Math.max(Math.max(diam1, diam2), diam3);

            return new TreeInfo(myHeight,myDiam);
        }

    }



    public static void main(String[] args) {

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println();

        System.out.println(tree.treeDiameterApproach1(root));
        System.out.println(tree.treeDiameterApproach2(root).diam);
    }
}
