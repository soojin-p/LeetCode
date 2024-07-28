import java.util.ArrayList;
import java.util.List;

class Solution { 
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // 보드 초기화
        for(int i=0; i<n; i++ ){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        // 백트래킹으로 배치할 수 있는 조합 탐색
        backtracking(ans, board, n, 0);

        return ans;
    }
    
    // 정답리스트에 저장할 보드배열을 만드는 함수
    private List<String> makingBoard(char[][] board){
        List<String> result  = new ArrayList<>(); 
        for(int i=0; i< board.length; i++){
            result.add(new String(board[i]));
        }
        return result;
    }
    private void backtracking(List<List<String>> ans, char[][] board, int n, int row){
       // 모든 행에 퀸을 배치했을 때 보드 생성
        if(row == n){
            ans.add(makingBoard(board));
            return;
       }
       // 행X && 대각X -> 열 배치
       for(int col =0; col<n; col++){
        if(isValid(board,row,col,n)){
            board[row][col]='Q';  // 퀸 배치
            backtracking(ans, board, n, row+1); // 다음 행에서 배치할 수 있는 조합 탐색
            board[row][col]='.'; 
        }
       }
    }
    int[][] dir = {{1,1},{-1,1}};
    private boolean isValid(char[][] board, int row, int col, int n){
        // 행에 퀸이 있는지 검사
        for(int i=0; i<row; i++){
            if(board[i][col]== 'Q') return false;
        }
        // 대각선 검사
         for(int i = row, j = col ; i>=0 && j>=0; i--, j-- ){
            if(board[i][j]== 'Q') return false;
         }
         for(int i = row, j = col ; i>=0 && j<n; i--, j++ ){
            if(board[i][j]== 'Q') return false;
         }
       return true;
     }
}