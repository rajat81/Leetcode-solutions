public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for(int current = n-2; current >= 0; current--) {
            // current+size should be within the array AND
            // size should be <= nums[current]
            for(int size = 1; size+current<n && size <= nums[current]; size++) {
                if(dp[current + size]) {
                    dp[current] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
}