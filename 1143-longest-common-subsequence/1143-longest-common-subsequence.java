class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int H = s.length(), W = t.length();
        if(H == 0 || W ==0) return 0;
        int[][] dp = new int[H][W];
        for(int i = 0; i< H; i++) {
            for(int j = 0; j<W; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = i-1 >= 0&&j-1>=0 ? dp[i-1][j-1]+1 : 1;
                }
                else {
                    dp[i][j] = 0;
                    if(i-1 >= 0) dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                    if(j-1 >= 0) dp[i][j] = Math.max(dp[i][j-1], dp[i][j]);
                }
            }
        }
        
        return dp[H-1][W-1];
    }
}