class Solution {
    public int maximalSquare(char[][] matrix) {
      
       int max =0;
       int row = matrix.length;
       int col = matrix[0].length;

       int[][] dp = new int[matrix.length][matrix[0].length];
       for(int i=0; i<row; i++)if(matrix[i] [0]=='1'){ 
            dp[i][0] =1;
            max=1;
        }
       for(int i=0; i<col; i++)if(matrix[0][i]=='1') {
            dp[0][i] =1;
            max=1;
       }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]=='1'){
                   dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                   max = Math.max(max,  dp[i][j]);
                }
            }
        }
        return max* max;
    }
}