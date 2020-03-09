package com.scj.leetcode.dp;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author shengchaojie
 * @date 2020-03-09
 **/
public class _121_买卖股票的最佳时机 {

    /**
     * 自创算法
     * 思想和动态规划类似。。。但是方向反了
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        int maxDay = -1;
        int minDay = -1;
        for (int i = prices.length - 1; i > 0; i--) {
            if (minDay >= i) {
                minDay = -1;
            }
            if (minDay != -1) {
                if (prices[i] > prices[maxDay]) {
                    max = prices[i] - prices[minDay];
                    maxDay = i;
                }
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] - prices[j] > max) {
                    max = prices[i] - prices[j];
                    maxDay = i;
                    minDay = j;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 先算前2天的最大收益 和 最小买入价
     * 迭代到最后一天
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i <= prices.length - 1; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        _121_买卖股票的最佳时机 _this = new _121_买卖股票的最佳时机();
        System.out.println(_this.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(_this.maxProfit(new int[]{7,6,4,3,1}));
//        System.out.println(_this.maxProfit(new int[]{1,7,2,4}));
    }

}
