/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit_k(2, prices);
    }

    public int maxProfit_k(int k, int[] prices) {
            int n = prices.length;
            k = Math.min(k, n/2);
            int[][] dp = new int[k+1][2];
            // base case
            for (int i = 0; i <= k; i++){
                dp[i][1] = -prices[0];
            }
            for (int i = 1; i < n; i++){
                for (int j = k; j > 0; j--){
                    dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j-1][0] - prices[i]);
                }
            }
            return dp[k][0];
        }
}
// @lc code=end

