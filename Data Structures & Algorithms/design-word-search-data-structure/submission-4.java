class WordDictionary {
    class TrieNode {
        boolean end;
        char c;
        TrieNode[] children;

        TrieNode(final char c) {
            this.c = c;
            this.end = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode(c);
            }
            curr = curr.children[i];

        }
        curr.end = true;
    }

    public boolean search(String word) {
        return suffixSearch(root, word, 0); 
    }

    private boolean suffixSearch(TrieNode start, String word, int startIndex) {
        TrieNode curr = start; //dog, do.. [0]
        int i = startIndex;//3
        for (; i < word.length(); i++) { //2 < 3
            char c = word.charAt(i); //.
            if (c != '.') {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            } else {
                for (TrieNode child: curr.children) {
                    if (child != null) {
                        //System.out.println("Child at " + i);
                        if (suffixSearch(child, word, i+1)) return true;
                    }
                }
                return false;
            }
        }
        if (curr.end == true && i == word.length())
            return true;
        else
            return false;
    }
}
