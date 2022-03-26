class Solution {
    public int maxProfit(int[] prices) {
        int prevMax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = prices.length-1; i>=0; i--) {
            if(prices[i] > prevMax) prevMax = prices[i];
            else {
                ans = Math.max(ans, prevMax - prices[i]);
            }
        }
        
        return ans;
    }
}