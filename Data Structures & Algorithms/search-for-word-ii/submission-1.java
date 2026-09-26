class Solution {
    class TrieNode {
        char currChar;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(final char c) {
            currChar = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    private void addWord(final TrieNode root, final String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode(c);
            }
            curr = curr.children[i];
        }
        curr.isWord = true;
    }

    private TrieNode search(final TrieNode root, final String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null)  return null;
            curr = curr.children[i];
        }
        if (curr == root) {
            return null;
        }
        else {
            return curr;
        }
    }

    private void buildTrie(String[] words) {
        this.root = new TrieNode(' ');
        for (String word: words) {
            addWord(root, word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        //TODO: base case: board null, words null/empty

        buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> foundWords = new HashSet<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                foundWords.addAll(dfs(board, x, y, "", visited));
            }
        }
        return foundWords.stream()
        .collect(Collectors.toList());
    }

    private Set<String> dfs(char[][] board, int x, int y, String currWord, boolean[][] visited) {
        int[][] directions = new int[][]{ {0, -1}, {-1, 0}, {1, 0}, {0, 1} };
        Set<String> output = new HashSet<>();
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == true) return output;

        String newWord = currWord + board[x][y];
        TrieNode result = search(root, newWord);
        if (result == null) return output;
        if (result.isWord) output.add(newWord);

        visited[x][y] = true;
        for (int[] d: directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            output.addAll(dfs(board, newX, newY, newWord, visited));
        }
        visited[x][y] = false;
        return output;
    }
}
