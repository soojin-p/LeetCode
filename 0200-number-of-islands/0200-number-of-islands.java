
class Solution {
    static int row;
    static int col;

    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static boolean[][] visited;

    public static boolean isValid(char[][] grid, int r, int c) {
        return (r >= 0 && r < row) && (c >= 0 && c < col) &&
         (grid[r][c] == '1')&& !visited[r][c];
    }

    public int numIslands(char[][] grid) {

        int count = 0;
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isValid(grid, i, j) && !visited[i][j]) {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c){
    visited[r][c] = true;
    for(int i=0; i<4; i++){
    int nextRow = r + dr[i];
    int nextCol = c + dc[i];

    if(isValid(grid, nextRow, nextCol)&& !visited[nextRow][nextCol])
    dfs(grid, nextRow, nextCol);

    }
    }
    public static void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (isValid(grid, nextRow, nextCol)) {
                    queue.offer(new int[] { nextRow, nextCol });
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

}