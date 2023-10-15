package Tries;

public class prefixProblem {
    static class Node {
        Node childern[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                childern[i] = null;
            }

            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void inset(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            } else {

                curr.childern[idx].freq++;
            }
            curr = curr.childern[idx];

        }
        curr.eow = true;
    }
    public static void findPrefix(Node root, String ans){
       if(root == null){
        return;
       }
       if(root.freq == 1){
        System.out.println(ans);
        return;
       }
        for(int i = 0 ; i < root.childern.length ; i++){
            if(root.childern[i] != null){
                findPrefix(root.childern[i], ans+(char)(i+'a'));
            }
        }
    }


    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words.length; i++) {
            inset(words[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
    }
}
