package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @author shengchaojie
 * @date 2020-05-09
 **/
public class _123_买卖股票的最佳时机III {

    /**
     * 状态
     * 第i天 至多发生k笔交易 状态为0或1
     * 选择
     * 买 卖 继续持有
     * 状态转移方程
     * dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i])
     * dp[i][1][1] = Math.max(dp[i-1][1][1],-prices[i])
     * dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i])
     * dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i])
     * base case
     * dp[i][0][0] = 0
     * dp[i][0][1] = - Integer.Max
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][1][0] = 0;
                dp[0][1][1] = - prices[0];
                dp[0][2][0] = 0;
                dp[0][2][1] = - prices[0];
                continue;
            }
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);

        }
        return dp[n - 1][2][0];
    }

    public static void main(String[] args) {
        _123_买卖股票的最佳时机III _this = new _123_买卖股票的最佳时机III();
//        System.out.println(_this.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(_this.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

}
