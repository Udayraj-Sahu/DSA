package Tries;

public class searchInTries {
    static class Node{
        Node childern[] = new Node[26];
        boolean eow= false;

        Node(){
            for(int i = 0 ; i < 26 ; i++)
            childern[i] = null;
        }
    }
    public static Node root = new Node();
    public static void inset(String word){
        Node curr = root;
        for(int level = 0 ; level < word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.childern[idx]== null){
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];

        }
        curr.eow = true;
    }
    public static boolean search(String key){
         Node curr = root;
        for(int level = 0 ; level < key.length();level++){
            int idx = key.charAt(level) - 'a';
            if(curr.childern[idx]== null){
                return false;
            }
            curr = curr.childern[idx];

        }
        return curr.eow == true;
    }
    public static void main(String[] args) {
        String words[] = {"the","a","there","their","any","thee"};
        for(int i = 0 ; i <words.length; i++){
            inset(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
