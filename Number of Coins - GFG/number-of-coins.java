//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    int[] dp = new int[V+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    for(int i = 1; i<=V; i++) {
	        for(int a:coins) {
	            if(i-a>0 && dp[i-a]!=Integer.MAX_VALUE) {
	                    dp[i] = Integer.min(1+dp[i-a], dp[i]);

	            } else if(i-a == 0) {
	                dp[i] = 1;
	            }
	                
	        }
	    }
	    
	    return dp[V] != Integer.MAX_VALUE ? dp[V]:-1;
	} 
}