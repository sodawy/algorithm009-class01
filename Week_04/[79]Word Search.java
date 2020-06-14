class WordSearch {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int xSize, ySize, wordLen;
    boolean[][] used;


    private boolean isArea(int x, int y) {
        return x >= 0 & y >= 0 && x < xSize && y < ySize;
    }

    private boolean _find(char[][] board, String word, int x, int y, int index) {
        if (index == wordLen - 1) {
            return true;
        }

        if(board[x][y] != word.charAt(index)){
            return false;
        }

        used[x][y] = true;

        //go to next pos
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isArea(newX, newY) && !used[newX][newY] && board[newX][newY] == word.charAt(index + 1)) {
                if (_find(board, word, newX, newY, index + 1)) {
                    return true;
                }
            }
        }

        used[x][y] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.xSize = board.length;
        this.ySize = board[0].length;
        this.wordLen = word.length();
        this.used = new boolean[xSize][ySize];

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (_find(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "ABCB"));

    }
}