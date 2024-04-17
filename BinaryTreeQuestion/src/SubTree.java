
class BinaryTree{
    static int idx = -1;

    SubTree.Node buildTree(int[] nodes){
        ++idx;
        if (nodes[idx] == -1){
            return null;
        }

        SubTree.Node nNode = new SubTree.Node(nodes[idx]);

        nNode.left = buildTree(nodes);
        nNode.right = buildTree(nodes);

        return nNode;
    }
    void preOrder(SubTree.Node root){

        if (root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    boolean isIdentical(SubTree.Node root, SubTree.Node subRoot){
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data == subRoot.data){
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }
        return false;
    }

    boolean isSubTree(SubTree.Node root, SubTree.Node subRoot){
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

        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
    }
}

public class SubTree {
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


    public static void main(String[] args) {

        // Main tree
        int[] nodes = {9, 7, 8, -1, -1, 1, 2, -1, -1, 3, -1, -1, 4,5,-1,-1,6,-1,-1};
        BinaryTree mTree = new BinaryTree();
        Node root = mTree.buildTree(nodes);
        mTree.preOrder(root);
        System.out.println();



        // sub Tree
        BinaryTree.idx = -1;
        int[] subNodes = {1,2,-1,-1,3,766,-1,-1,-1};
        BinaryTree subTree = new BinaryTree();
        Node subRoot = subTree.buildTree(subNodes);
        mTree.preOrder(subRoot);
        System.out.println();

        System.out.println();

        System.out.println(mTree.isSubTree(root,subRoot));

    }
}
