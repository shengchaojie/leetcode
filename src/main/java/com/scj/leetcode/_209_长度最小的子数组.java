package com.scj.leetcode;

import java.util.Arrays;

/**
 * @author shengchaojie
 * @date 2020/6/28
 **/
public class _209_长度最小的子数组 {

    /**
     * 暴力法
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int end = i;
            while (sum < s && end < nums.length) {
                sum += nums[end++];//这边多加了1
            }
            if (sum >= s) {
                min = Math.min(min, end - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 双指针
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen3(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int index = Arrays.binarySearch(sums, target);//需要注意binarySearch的返回结果
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= n) {
                ans = Math.min(ans, index - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        _209_长度最小的子数组 _this = new _209_长度最小的子数组();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(_this.minSubArrayLen3(11, arr));
    }

}
