class Trie {
    
    Node head;
    
    public class Node
    {
        Node[] child;        
        boolean isEnd;
        public Node()
        {
            child = new Node[26];
            isEnd = false;
            for(int  i = 0; i < 26; i++)
            {
                child[i] = null;
            }
        }        
    }

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        int letter = 0;
        Node curr = head;
        for(int i = 0; i < len; i++)
        {
            letter = word.charAt(i) - 'a';
            if(curr.child[letter] == null)
            {
                curr.child[letter] = new Node();
            }
            curr = curr.child[letter];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        int letter = 0;
        Node curr = head;
        for(int i = 0; i < len; i++)
        {
            letter = word.charAt(i) - 'a';
            if(curr.child[letter] == null)
                return false;
            curr = curr.child[letter];
        }
        return (curr.isEnd);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        int letter = 0;
        Node curr = head;
        for(int i = 0; i < len; i++)
        {
            letter = prefix.charAt(i) - 'a';
            if(curr.child[letter] == null)
                return false;
            curr = curr.child[letter];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */