class Solution {
    
    
    public int findMaxForm(String[] str, int m, int n) {
        int[][][] dp = new int[m+1][n+1][str.length];
        
        for(int[][] a:dp) {
            for(int[] b:a) {
                Arrays.fill(b, -1);
            }
        }
        
        return solve(str, m ,n, 0, dp);
    }
    
    
    public int solve(String[] str, int m, int n, int index, int[][][] dp) {
        
        if(index == str.length) {
            return 0;
        }
        
        if(dp[m][n][index] != -1) {
            return dp[m][n][index];
        }
        
        int zeroCount = getCount(str[index], '0');
        int oneCount = getCount(str[index], '1');
      
        if(m-zeroCount >= 0 && n-oneCount>= 0) {
            dp[m][n][index] = Integer.max(solve(str, m,n,index+1, dp),
                              solve(str, m-zeroCount, n-oneCount, index+1, dp)+1);
        } else {
            dp[m][n][index] = solve(str, m , n, index+1, dp);
        }
        
        return dp[m][n][index];
    }
    
    private int getCount(String s, char p) {
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == p) {
                count++;
            }
        }
        
        return count;
    }
}