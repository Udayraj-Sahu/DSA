package Tries;

public class uniqueSubstring {
    static class Node {
        Node childern[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++)
                childern[i] = null;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];

        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                return false;
            }
            curr = curr.childern[idx];

        }
        return curr.eow == true;
    }

    public static int countNodes(Node root){
        if(root == null) return 0;
        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
          if(root.childern[i] != null)
            count+= countNodes(root.childern[i]);
        }
        return count+1;
    }
    public static void main(String[] args) {
        String str = "ababa";

        for(int i= 0 ; i < str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root) );
    }
}
