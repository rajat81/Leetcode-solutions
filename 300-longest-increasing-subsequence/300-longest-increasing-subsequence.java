class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] has the length of max subsequence till i th element
        for(int i = 0; i<n; i++) {
            dp[i] = 1;
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}