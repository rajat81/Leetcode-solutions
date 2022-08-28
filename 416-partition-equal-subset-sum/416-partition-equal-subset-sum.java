class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length; i++) {
            sum += nums[i];
        }
        int target;
        if(sum % 2 == 1) return false;
        target = sum/2;
        
        boolean[][] dp = new boolean[target+1][nums.length+1];
        
        
        for(int i = 0; i<= target; i++) {
            for(int j = 0;j<=nums.length; j++) 
                dp[i][j] = false;
        }
        
        for(int i = 0; i<=nums.length; i++) {
            dp[0][i] = true;
        }
        
        for(int i=1; i<= target; i++) {
            for(int j = 1; j<=nums.length; j++) {
                
                if(i >= nums[j-1])
                    dp[i][j] = dp[i][j-1] || dp[i-nums[j-1]][j-1];
                else  {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        
        return dp[target][nums.length];
    }
}