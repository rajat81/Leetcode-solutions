class Solution {
    public int minPathSum(int[][] grid) {
        int H = grid.length;
        int W = grid[0].length;
        
        int[][] dp = new int[H][W];
        
        dp[0][0] = grid[0][0];
        
        
        for(int i=0; i<H; i++) {
            for(int j = 0; j<W; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else {
                    if(i-1 >= 0 && j-1 >= 0) {
                        dp[i][j] = Integer.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                    } else if(j-1>=0) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }
            }
        }
        
        return dp[H-1][W-1];
    }
}