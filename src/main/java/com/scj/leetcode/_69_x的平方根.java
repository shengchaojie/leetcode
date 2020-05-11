package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-11
 **/
public class _69_x的平方根 {

    public int mySqrt(int x) {
        if(x==0||x==1)return x;
        long left = 0, right = x;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)left -1;
    }

    public static void main(String[] args) {
        _69_x的平方根 _this = new _69_x的平方根();
        System.out.println(_this.mySqrt(2147395599));
    }

}
