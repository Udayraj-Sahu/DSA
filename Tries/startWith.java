package Tries;

public class startWith {
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

    public static boolean startWiths(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.childern[idx] == null) {
                return false;
            }

            curr = curr.childern[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";
        String prefix2 = "moon";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(startWiths(prefix1));
        System.out.println(startWiths(prefix2));
    }
}
