class Solution {
    public int maximalSquare(char[][] matrix) {
				//✅ 왼쪽 끝단과 상단을 한 줄 추가하여 DP를 0으로 초기화 해준다. (전처리)
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max_side = 0;
				//✅ (1, 1)을 시작으로 matrix를 순회한다.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
								//✅ 현재 위치의 값이 1일 때
                if (matrix[i-1][j-1] == '1') {
										//✅ 점화식에 따라 현재 위치에 최대 크기의 정사각형 한 변의 길이를 저장한다.
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
								//✅ 최대 크기의 정사각형 한 변의 길이를 갱신한다.
                max_side = Math.max(max_side, dp[i][j]);
            }
        }
				//✅ 최대 크기의 정사각형의 넓이를 반환한다.
        return max_side * max_side;
    }
}