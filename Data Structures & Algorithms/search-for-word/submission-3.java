class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    System.out.println("Starting at  " + i + " " + j);
                    if (existenceTraversal(board, i, j, word, "", visited))
                        return true;
                }
            }
        }
        return false;
    }
//ABCE
//SFES
//ADEE
    private boolean existenceTraversal(
        final char[][] board, int i, int j, String word, String prefix, boolean[][] visited) {
        int[][] directions = new int[][] {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
            return false;
        if (visited[i][j]) return false;

        String newPrefix = prefix + board[i][j];
        if (!word.contains(newPrefix))
            return false;
        System.out.println("Found " + newPrefix + " at  " + i + " " + j);
        visited[i][j] = true;
        if (word.equals(newPrefix)) return true;
        for (int[] direction : directions) {
            if (existenceTraversal(board, i + direction[0], j + direction[1], word, newPrefix, visited))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
