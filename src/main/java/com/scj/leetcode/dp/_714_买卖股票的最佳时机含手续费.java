package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 在122的基础上加上费用
 * @author shengchaojie
 * @date 2020-05-09
 **/
public class _714_买卖股票的最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1 ; i < n ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

}
