class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        int max = amount + 1;

        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        // DP 
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    
                }
            }
        }
       
        // dp[amount]가 초기화된 값이면 -1 반환
        return dp[amount] == max ? -1 : dp[amount];
    }
}
