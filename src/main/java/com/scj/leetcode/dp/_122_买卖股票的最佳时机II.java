package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author shengchaojie
 * @date 2020-05-09
 **/
public class _122_买卖股票的最佳时机II {

    /**
     * 状态
     *  第i天 持有状态k(1 持有 2 未持有
     * 选择
     *  买 卖 继续持有
     * 状态转移方程
     *  dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     *  dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     * base case
     *  dp[0][0] = 0
     *  dp[0][1] = -prices[i]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1 ; i < n ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

}
