import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;

    }
}


public class Traversal_Trees {
    static Node creation(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value : ");
        int data = sc.nextInt();
        Node root;

        //Recurtion is start from below
        if(data == -1)
            return null;

            root = new Node(data);
            System.out.println("Enter Left child of "+root.data);
            root.left= creation();
    
            System.out.println("Enter right child of : "+root.data);
            root.right = creation();
    
            return root;
            
        

            
    }

    static void inorder(Node root){//LNR

        if(root == null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    static void preorder(Node root){//NLR
        if(root == null)
        return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root){//LRN
        if(root == null)
        return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    public static void main(String[] args) {
        
        Node root = creation();
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        inorder(root);
    }



    
}