class Solution {
    static int row;
    static int col;
    static boolean[][] visited;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    private boolean isValid(int[][] grid, int r, int c) {
        return (r >= 0 && r < row) && (c >= 0 && c < col) && (grid[r][c] == 0) && !visited[r][c];
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        visited = new boolean[row][col];
        
        //시작 셀이 1이거나 도착셀이 1이면 return -1;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        
        return bfs(grid, 0, 0);
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });
        visited[r][c] = true;
        int pathCount =1;

        // bfs 
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];

                // 도착 셀에 도착하면, pathCount return;
                if (curRow == row - 1 && curCol == col - 1) {
                    return pathCount;
                }

                for (int j = 0; j < 8; j++) {
                    int nextRow = curRow + dr[j];
                    int nextCol = curCol + dc[j];

                    if (isValid(grid, nextRow, nextCol)) {
                        queue.offer(new int[] { nextRow, nextCol });
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            pathCount++;
        }
        return -1;
    }
}