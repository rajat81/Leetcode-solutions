class Solution {
    public int maxProfit(int[] prices) {
        // 7 1 5 3 700 4
        //   0 6 6 6 0 0
        // 2 choices -> if not currently having - buy the stock
        //                                         do not buy
          /*           if have already - sell 
                                       no sell
            */
        
        int profit = 0;
        for(int i = 0; i< prices.length-1; i++) {
            if(prices[i+1] > prices[i]) {
                profit +=  prices[i+1] - prices[i];
            }
        }
        
        return profit;
    }
   
}