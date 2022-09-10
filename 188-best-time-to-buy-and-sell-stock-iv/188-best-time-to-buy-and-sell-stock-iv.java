class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if(k> n/2) {
            int ans = 0;
            for(int i =1; i<prices.length; i++) {
                ans += (prices[i] - prices[i-1]) > 0 ? prices[i] - prices[i-1]: 0;
            }
            return ans;
        }
        
    //    int[][] dp = new int[prices.length][k+1];
      
        int[][] dp = new int[k+1][prices.length];
        
        for(int[] p: dp) Arrays.fill(p, 0);
        
        // int maxDiff = -prices[0];
        
        for(int trans=1; trans<= k; trans++) {
            int maxDiff = -prices[0];
            
            for(int item=1; item<prices.length; item++) {
                dp[trans][item] = Integer.max(dp[trans][item-1], prices[item]+maxDiff);
                
                maxDiff = Integer.max(maxDiff, -prices[item] + dp[trans-1][item]);
            }
        }
        
//         for(int i = 1; i<prices.length; i++) {
//             for(int j = 1; j<=k; j++) {
                
//                   dp[i][j] = Integer.max(dp[i][j-1], 
//                                         prices[i] + maxDiff
//                                       );
//                   System.out.print(dp[i][j] + " ");
//                   if(i<prices.length) maxDiff = Integer.max(maxDiff, dp[i][j-1] - prices[i]);
//                 System.out.println("MaxDiff: " + maxDiff);
//             }
            
//         }
        return dp[k][n-1];
    }
}