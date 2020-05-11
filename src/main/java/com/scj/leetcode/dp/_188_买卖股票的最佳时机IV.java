package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author shengchaojie
 * @date 2020-05-09
 **/
public class _188_买卖股票的最佳时机IV {

    /**
     * 状态
     * 在第i天 至多k次 是否持有股票
     * 选择
     * 买 卖 持有
     * 状态转移方程
     * dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * base case
     * dp[-1][k][0] = 0
     * dp[-1][k][1] = - min
     * dp[i][0][0] = 0
     * dp[i][0][1] = - min
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        if (k > n >> 1) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                if(i==0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = - prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

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
