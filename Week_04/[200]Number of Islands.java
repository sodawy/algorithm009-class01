class NumerofIslands {

    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int xSize, ySize;
    boolean[][] used;
    int ret;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        ret = 0;
        xSize = grid.length;
        ySize = grid[0].length;
        used = new boolean[xSize][ySize];

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if(grid[i][j] == '1' && !used[i][j]){
                    _colorful(grid, i, j);
                    ret++;
                }

            }
        }

        return ret;
    }

    private void _colorful(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= xSize || y >= ySize) return;
        if (used[x][y]) return;
        if (grid[x][y] == '0') return;

        used[x][y] = true;

        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            _colorful(grid, newX, newY);
        }
    }

    public static void main(String[] args) {
        NumerofIslands numerofIslands = new NumerofIslands();
        char[][] input = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
        };
        System.out.println(numerofIslands.numIslands(input));

    }
}