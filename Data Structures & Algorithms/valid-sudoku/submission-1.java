class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> colMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> boardMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int currNum = (int) board[i][j];
                

                if (rowMap.containsKey(i) && rowMap.get(i).contains(currNum)) {
                    return false;
                } else {
                    addToMap(rowMap, i, currNum);
                }
                
                if (colMap.containsKey(j) && colMap.get(j).contains(currNum)) {
                    return false;
                } else {
                    addToMap(colMap, j, currNum);
                }
                int boardIndex = getBoardIndex(i, j);

                if (boardMap.containsKey(boardIndex) && boardMap.get(boardIndex).contains(currNum)) {
                    return false;
                } else {
                    addToMap(boardMap, boardIndex, currNum);
                }
            }
        }

        return true;
    }

    private void addToMap(Map<Integer, Set<Integer>> map, int index, int num) {
        if (map.containsKey(index)) {
            map.get(index).add(num);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(num);
            map.put(index, set);
        }
    }

    private int getBoardIndex(final int i, final int j) {
        if (i < 3 && j < 3) {
            return 1;
        } else if (i >= 3 && i < 6 && j < 3) {
            return 2;
        } else if (i >= 6 && i < 9 && j < 3) {
            return 3;
        } else if (i < 3 && j >= 3 && j < 6) {
            return 4;
        } else if (i >= 3 && i < 6 && j >= 3 && j < 6) {
            return 5;
        } else if (i >= 6 && i < 9 && j >= 3 && j < 6) {
            return 6;
        } else if (i < 3 && j >= 6 && j < 9) {
            return 7;
        } else if (i >= 3 && i < 6 && j >= 6 && j < 9) {
            return 8;
        } else if (i >= 6 && i < 9 && j >= 6 && j < 9) {
            return 9;
        }
        return -1;
    }
}