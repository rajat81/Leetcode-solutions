class Solution {
    public int maxSubArray(int[] nums) {
        int gsum = Arrays.stream(nums).max().getAsInt(), lsum = 0;
        for(int p:nums) {
            if(lsum+p > 0) {
                lsum += p;
                gsum = Math.max(gsum, lsum);
            } else {
                lsum = 0;
            }
        }
        
        return gsum;
    }
}