import java.util.*;

class Solution {
    public int solve(int[] prices, int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        for(int i = 1; i<= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + prices[j-1]);
            }
        }

        return dp[n];
    }
}


/*

https://binarysearch.com/problems/Rod-Cutting


Rod Cutting
Medium

You are given a list of integers prices where prices[i] represents the price to sell a rod of size i + 1, and an integer n which represents the current size of the rod.

Given you can cut the rod into any number of different sizes, return the maximum profit that can be earned.

Constraints

m = n ≤ 1000 where m is the length of prices.
Example 1
Input
prices = [1, 3, 5, 7, 7, 7]
n = 6
Output
10
Explanation
The price table shows that we can

Sell a rod of size 1 for price of 1
Sell a rod of size 2 for price of 3
Sell a rod of size 3 for price of 5
Sell a rod of size 4 for price of 7
Sell a rod of size 5 for price of 7
Sell a rod of size 6 for price of 7
The optimal way to cut the rod is to split it into 2 pieces of length 3, to achieve profit of 10.


*/
