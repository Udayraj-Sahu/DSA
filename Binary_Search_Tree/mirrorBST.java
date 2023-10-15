package Binary_Search_Tree;

public class mirrorBST {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
        }
    }
public static void preorder(Node root){
        if(root == null) return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
     }
    public static Node createMirror(Node root){
        if(root == null) return null;

        Node leftmirror = createMirror(root.left);
        Node rightmirror = createMirror(root.right);

        root.left = rightmirror;
        root.right = leftmirror;
        return root;
    }
     
    public static void main(String[] args) {
       Node root = new Node(8);
       root.left = new Node(5);
       root.right = new Node(10);
       root.left.left = new Node(3);
       root.left.right = new Node(6);
       root.right.right = new Node(11);

       root = createMirror(root);
       preorder(root);
    }
}
