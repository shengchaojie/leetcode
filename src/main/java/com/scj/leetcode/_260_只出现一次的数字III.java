package com.scj.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author shengchaojie
 * @date 2020-05-16
 **/
public class _260_只出现一次的数字III {


    /**
     * 先对所有数进行异或 然后找出不同那两个数哪一位第一次开始不同 然后将数组分成两堆 再次进行异或
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }
//        int first = 1;
//        while ((sum & first) == 0) {
//            first <<= 1;
//        }
        int first = sum & -sum;
        int one = 0;
        for (int num : nums) {
            if ((num & first) == first) {
                one = one ^ num;
            }
        }
        return new int[]{one, one ^ sum};
    }

    public static void main(String[] args) {
        _260_只出现一次的数字III _this = new _260_只出现一次的数字III();
        Arrays.stream((_this.singleNumber(new int[]{1193730082,587035181,-814709193,1676831308,-511259610,284593787,-2058511940,1970250135,-814709193,-1435587299,1308886332,-1435587299,1676831308,1403943960,-421534159,-528369977,-2058511940,1636287980,-1874234027,197290672,1976318504,-511259610,1308886332,336663447,1636287980,197290672,1970250135,1976318504,959128864,284593787,-528369977,-1874234027,587035181,-421534159,-786223891,933046536,959112204,336663447,933046536,959112204,1193730082,-786223891}))).forEach(System.out::println);
    }

}
