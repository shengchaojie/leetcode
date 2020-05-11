package com.scj.leetcode.dp;

/**
 * 在122的基础上修改时间
 * @author shengchaojie
 * @date 2020-05-09
 **/
public class _309_最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            if(i==0){
                dp[i][0] = Math.max(0,Integer.MIN_VALUE+prices[i]);
                dp[i][1] = Math.max(Integer.MIN_VALUE,-prices[i]);
                continue;
            }
            if(i==1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
                continue;
            }

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }

}
