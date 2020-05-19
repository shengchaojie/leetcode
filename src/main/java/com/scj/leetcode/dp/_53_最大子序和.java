package com.scj.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author shengchaojie
 * @date 2020-03-09
 **/
public class _53_最大子序和 {

    /**
     * 一个最大连续正数 一定是正正相加
     * 如果之前累积的数变成负数 那么直接抛弃
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(res>0){
                res = res + nums[i];
            }else{
                res = nums[i];
            }
            max = Math.max(res,max);
        }

        return max;
    }

    /**
     * 状态
     * 以i为结尾的最大子数组
     * 选择
     * 选择i 不选择i
     * 状态转移方程
     * dp[i] = max(nums[i],dp[i-1]+nums[i])
     * base case
     * dp[0] = nums[0]
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i =1; i< n; i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        _53_最大子序和 _this = new _53_最大子序和();
        System.out.println(_this.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(_this.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
