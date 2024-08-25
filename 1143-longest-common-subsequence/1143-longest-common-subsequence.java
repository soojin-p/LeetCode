class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); 
        int n = text2.length(); 

        // dp[i][j]는 text1의 처음 i개의 문자와 text2의 처음 j개의 문자를 비교했을 때의 LCS 길이를 저장
        int[][] dp = new int[m + 1][n + 1];

        // dp 배열을 채워나가는 반복문
        for (int i = 1; i <= m; i++) { // text1의 각 문자를 순회
            for (int j = 1; j <= n; j++) { // text2의 각 문자를 순회
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { 
                    // 만약 text1의 i번째 문자와 text2의 j번째 문자가 같다면,
                    // 현재 문자가 공통 부분 수열에 포함되므로, dp[i-1][j-1]에 1을 더한 값을 dp[i][j]에 저장
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 문자가 같지 않다면,
                    // 현재 문자가 공통 부분 수열에 포함되지 않으므로,
                    // dp[i-1][j] (위쪽 셀) 또는 dp[i][j-1] (왼쪽 셀) 중 큰 값을 선택하여 dp[i][j]에 저장
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최종적으로 text1과 text2의 가장 긴 공통 부분 수열의 길이가 저장됨
        return dp[m][n];
    }
}
