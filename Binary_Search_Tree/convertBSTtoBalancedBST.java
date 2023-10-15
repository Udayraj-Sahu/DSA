package Binary_Search_Tree;

import java.util.ArrayList;

import Stack.reverseStack;

public class convertBSTtoBalancedBST {
    public class sortedArrayToBST {
        static class Node {
            int data;
            Node right;
            Node left;

            Node(int data) {
                this.data = data;
            }
        }

        public static void preorder(Node root) {
            if (root == null)
                return;

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void getInorder(Node root, ArrayList<Integer> inOrder) {
            if (root == null)
                return;

            getInorder(root.left, inOrder);
            inOrder.add(root.data);
            getInorder(root.right, inOrder);
        }
        public static Node createBST(ArrayList<Integer> inorder , int st , int end){
            if(st > end){
                return null;
            }

            int mid = (st+end)/2; 

            Node root = new Node(inorder.get(mid));
            root.left = createBST(inorder, st, mid-1);
            root.right = createBST(inorder, mid+1, end);
            return root;
        }
        public static Node balanceBST(Node root) {
            ArrayList<Integer> inOrder = new ArrayList<>();
            getInorder(root, inOrder);

            root = createBST(inOrder, 0, inOrder.size()-1);
            return root;
        }

        public static void main(String[] args) {
            Node root = new Node(8);
            root.left = new Node(6);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);

            root.right = new Node(10);
            root.right.right = new Node(11);
            root.right.right.right = new Node(12);

            root = balanceBST(root);
            preorder(root);
            
        }
    }
}