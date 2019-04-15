package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class WordDictionary211 {
    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    private TrieNode root = new TrieNode();

    public void addWord(String word){
        TrieNode root = this.root;
        for (int i = 0 ; i < word.length() ;i++){
            if(root.children[word.charAt(i)-'a'] == null){
                root.children[word.charAt(i)-'a'] = new TrieNode();
            }
            root =  root.children[word.charAt(i)-'a'];
        }
        root.item = word ;
    }

    public boolean search(String word){
        return match(word.toCharArray(),0,root);
    }

    private boolean match(char[] chars, int index, TrieNode root) {
        if(index == chars.length){
            // check if item string exists
            return !root.item.equals("");
        }
        if(chars[index]!='.'){
            return root.children[chars[index]-'a']!=null && match(chars,index+1,root.children[chars[index]-'a']);
        }else {
            for (int i = 0 ; i< root.children.length;i++){
                if(root.children[i]!=null){
                    if(match(chars,index+1,root.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
