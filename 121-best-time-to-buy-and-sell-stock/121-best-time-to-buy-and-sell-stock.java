class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, prevMin = Integer.MAX_VALUE;
        
        for(int p:prices) {
            if(prevMin > p) {
                prevMin = p;
            } else {
                ans = Math.max(ans, p - prevMin);
            }
        }
        return ans;
    }
}