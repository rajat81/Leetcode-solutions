class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length+1];
        
        for(int i = 0; i<=amount; i++) dp[i][0] = 0;
        for(int i=0; i<=coins.length; i++) dp[0][i] = 1;
        
        for(int i=1; i<=amount; i++) {
            for(int j = 1; j<= coins.length; j++) {
                int v = (i>=coins[j-1])?dp[i-coins[j-1]][j]:0;
                dp[i][j] = dp[i][j-1] + v;
            }
        }
        
        return dp[amount][coins.length];
    }
}