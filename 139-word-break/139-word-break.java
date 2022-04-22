class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++) {
            for(String word: wordDict) {
                if(i+word.length()-1 <= s.length() && s.substring(i-1, i-1+word.length()).equals(word)) {
                    dp[i+word.length()-1] = dp[i+word.length()-1] || dp[i-1];
                }
            }
        }
        return dp[s.length()];
    }
}