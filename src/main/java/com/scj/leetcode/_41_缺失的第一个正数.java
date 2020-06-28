package com.scj.leetcode;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author shengchaojie
 * @date 2020/6/28
 **/
public class _41_缺失的第一个正数 {

    /**
     * 置换法
     * 正确的数字换到正确的位子，第一个不对的数字即没出现的最小整数
     * 注意 数组空返回1 数组满返回的是n+1
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 将数组转换为hash使用
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        //小于等于0的槽 置为n+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        //绝对值小于等于n的槽 对应index-1的槽 置为对应负数
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -1 * Math.abs(nums[num - 1]);
            }
        }
        //第一个不为负数的槽 即缺失的第一个正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >0) {
                return i + 1;
            }
        }
        //如果所有数都为负数 那么返回n+1
        return nums.length + 1;
    }

    public static void main(String[] args) {
        _41_缺失的第一个正数 _this = new _41_缺失的第一个正数();
        int[] arr = new int[]{1};
        System.out.println(_this.firstMissingPositive2(arr));
    }

}
