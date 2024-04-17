import java.util.ArrayList;

public class BST {
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
    public static Node insert(Node root,int data){
        if (root == null){
            return new Node(data);
        }

        if (root.data > data){
            root.left = insert(root.left,data);
        }

        if (root.data < data){
            root.right = insert(root.right,data);
        }

        return root;
    }

    public static void inorder(Node root){
        if (root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

//    public static Boolean searchKey(Node root,int key){
//        if (root == null){
//            return false;
//        }
//
//        if (root.data > key){
//            return searchKey(root.left,key);
//        }
//
//        if (root.data< key){
//            return searchKey(root.right, key);
//        }
//
//        if (root.data == key){
//            return true;
//        }
//        return false;
//    }

    public static Node deleteNode(Node root,int val){
        if (root == null){
            return null;
        }

        if (root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else if (root.data < val){
            root.right = deleteNode(root.right, val);
        }
        else{ // root.data == val

//            case: 1 delete Node has no child
            if (root.left == null && root.right == null){
                return null;
            }

//            case: 2 delete node has one child
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }


//            case: 3 delete node has two child
//            first we need to find inorder successor : left most in right subtree
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right =  deleteNode(root.right,IS.data);

        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void printInRange(Node root,int X,int Y){
        if (root == null){
            return;
        }
        if (root.data >= X && root.data <= Y){
            printInRange(root.left,X,Y);
            System.out.print(root.data+" ");
            printInRange(root.right,X,Y);
        }
        else if(root.data >= Y){
            printInRange(root.left,X,Y);
        }
        else{
            printInRange(root.right,X,Y);
        }
    }


    public static void printAllPaths(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null){
            printPath(path);
        }else{
            printAllPaths(root.left, path);
            printAllPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer> path){
        for (int i =0; i< path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] data = {5,1,3,4,2,7};
        Node root = null;

        for (int i=0; i < data.length; i++){
            root = insert(root,data[i]);
        }

        inorder(root);
        System.out.println();

//        System.out.println(searchKey(root,2));
        deleteNode(root,3);
        inorder(root);

//        printInRange(root,3,5);

//        printAllPaths(root, new ArrayList<Integer>());
    }
}
