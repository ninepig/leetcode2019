package amazon;

/**
 * Created by yangw on 2019/4/9.
 */
public class TrieTree {
    class TrieNode{
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){

        }
        public TrieNode(char c){
            TreeNode node = new TreeNode(c);
            node.val = c;
        }
    }

    private TrieNode root;
    public TrieTree(){
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word){
        TrieNode ws = root;
        // insert one by one.
        for (int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    // need return ws.isWord!!
    public boolean search(String word){
        TrieNode ws = root;
        for (int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c-'a'];
        }
        return ws.isWord;
    }
    public  boolean startWith(String prefix){
        TrieNode ws = root;
        for (int i = 0 ; i < prefix.length() ; i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c-'a'];
        }
        return true;
    }
}