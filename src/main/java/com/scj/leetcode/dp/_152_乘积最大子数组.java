package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author shengchaojie
 * @date 2020-05-18
 **/
public class _152_乘积最大子数组 {

    /**
     * 选择 是否包括第i个数 正负
     * 状态 包括 不包括
     * 转移方程
     * nums[i] >=0
     * dp[i][1] = Math.max(nums[i],dp[i-1][1]*nums[i])
     * dp[i][0] = Math.min(nums[i],dp[i-1][0]*nums[i])
     * nums[i]<0
     * dp[i][1] = Math.max(nums[i],dp[i-1][0]*nums[i])
     * dp[i][0] = Math.min(nums[i],dp[i-1][1]*nums[i])
     * base case
     * dp[0][i] = nums[i]
     *
     * 因为负负得正
     * 所以要求出每一位的最大值 和 最小值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0][1] = nums[0];
                dp[0][0] = nums[0];

                continue;
            }

            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            }


            max = Math.max(max, dp[i][1]);
        }
        return max;

    }

    public static void main(String[] args) {
        _152_乘积最大子数组 _this = new _152_乘积最大子数组();
        System.out.println(_this.maxProduct(new int[]{2, 3, -2, -4}));
    }

}
