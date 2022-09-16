class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int ans1 = solve(Arrays.copyOfRange(nums, 1, nums.length));
        int ans2 = solve(Arrays.copyOfRange(nums, 0, nums.length-1));
        
        return Integer.max(ans1, ans2);
    }
    
    
    public int solve(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        
        dp[n-1] = nums[n-1];
        
        for(int i=nums.length-1; i>=0; i--) {
            if(i+1 >= n) {
                dp[i] = nums[i];
            } else {
                dp[i] = Integer.max(nums[i], dp[i+1]);
                if(i+2<n) {
                    dp[i] = Integer.max(dp[i], nums[i] + dp[i+2]);
                }
                
                if(i+3<n)
                    dp[i] = Integer.max(dp[i], dp[i+3]+nums[i]);
            }
        }
        return dp[0];
        
    }
}