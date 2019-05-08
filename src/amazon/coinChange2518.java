package amazon;

/**
 * Created by yangw on 2019/4/28.
 */
public class coinChange2518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1 ; i <= coins.length ; i++) {
            // initialization
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
//  dp[i - 1][j]: means the number of combinations if we compeletly don't use the ith coin
//  dp[i][j - coins[i - 1]]: we must use at least one of the ith coin, so we expell the ith coin from j (Exclusive, opposite to the upper condition)
                dp[i][j] = dp[i - 1][j] + (j > coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
