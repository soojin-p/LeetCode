class Solution {
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static int row;
    static int col;

    static boolean[][] visited;

    public static boolean isValid(char[][] grid, int r, int c) {
        return (r >= 0 && r < row) && (c >= 0 && c < col) && (grid[r][c] =='1');
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0; j<col ;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid);
                    count++;
                }
              
            }
        }
        return count;
    }

    public static void dfs(int r, int c, char[][] grid) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];

            if(isValid(grid, nextRow, nextCol) && !visited[nextRow][nextCol])
                dfs(nextRow, nextCol, grid);
        }
    }
}