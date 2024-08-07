// Coin change - min number of coins

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length+1];

        for(int[] a:dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for(int j= 0; j<=coins.length; j++)
            dp[0][j] = 0;

        for(int i=1; i<= amount; i++) {
            for(int j = 1; j<=coins.length; j++) {
                int value = coins[j-1];
                if(i - value >= 0 && dp[i-value][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Integer.min(dp[i][j-1], dp[i-value][j] + 1);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[amount][coins.length] == Integer.MAX_VALUE ? -1 : dp[amount][coins.length];
    }
}


// OPTIMAL approach ->

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // min no of coins needed to get to amount i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            for(var coin: coins) {
                if(i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
