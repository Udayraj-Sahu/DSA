package Tries;

public class wordBreakProblem {
    static class Node {
        Node childern[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++)
                childern[i] = null;
        }
    }

    public static Node root = new Node();

    public static void inset(String word) {
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

    /**
     * The function searches for a given key in a trie data structure and returns true if the key is
     * found, false otherwise.
     * 
     * @param key The key parameter is a string that represents the word we are searching for in the
     * trie data structure.
     * @return The method is returning a boolean value. It returns true if the key is found in the
     * trie, and false otherwise.
     */
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

  /**
   * The function `wordBreak` checks if a given string can be broken into valid words based on a
   * predefined set of words.
   * 
   * @param key The parameter `key` is a string that represents the input word that needs to be broken
   * into valid words.
   * @return The method `wordBreak` returns a boolean value. It returns `true` if the given `key` can
   * be broken into valid words, and `false` otherwise.
   */
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {

            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // substring (begging idx, last idx)
            if (search(key.substring(0, i)) &&
                    wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like","sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words.length; i++) {
            inset(words[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));

    }
}
