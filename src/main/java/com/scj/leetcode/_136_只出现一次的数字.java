package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-14
 **/
public class _136_只出现一次的数字 {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        _136_只出现一次的数字 _this = new _136_只出现一次的数字();
        System.out.println(_this.singleNumber(new int[]{2, 2, 1}));
    }

}
