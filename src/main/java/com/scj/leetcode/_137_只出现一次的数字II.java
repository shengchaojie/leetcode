package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-16
 **/
public class _137_只出现一次的数字II {

    /**
     * 状态机
     * 按照每一位的状态来看 一共可能有 0 1 2 3 4个状态
     * 其中0和3是一样的
     * 一个比特只能表示2个状态
     * 所以我们用one 0 表示0/3次  1表示1次
     * two 1 表示2次
     * one ^ num 表示进位 (0^1 1^0 进位变成1 1^1 进位变成0 0^0保持不变)
     * ~two 表示限制 two必须等于0
     * two ^ num 表示进位
     * ~one 表示限制 two必须等于0
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }

    /**
     * 每一位单独计算次数 我们需要只出现一次的位
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            if(count % 3 ==1){
                result = result | (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _137_只出现一次的数字II _this = new _137_只出现一次的数字II();
//        System.out.println(_this.singleNumber(new int[]{1,2,2,2}));
        System.out.println(_this.singleNumber2(new int[]{1,2,2,2}));
    }


}
