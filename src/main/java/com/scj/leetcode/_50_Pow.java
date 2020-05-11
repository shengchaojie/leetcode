package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-11
 **/
public class _50_Pow {

    public double myPow(double x, int n) {
        //int转换为long 防止取负数时候溢出
        long temp = n;
        return n > 0 ? quickPow2(x, temp) : 1 / quickPow2(x, -temp);
    }

    /**
     * 快速幂 迭代实现
     *
     * @param x
     * @param n
     * @return
     */
    public double quickPow(double x, long n) {
        double res = 1.0d;
        for (long i = n; i > 0; i >>= 1) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }

    /**
     * 快速幂 递归
     *
     * @param x
     * @param n
     * @return
     */
    public double quickPow2(double x, long n) {
        if (n == 0) return 1.0d;
        double result = quickPow2(x, n >> 1);
        if (n % 2 == 1) {
            return x * result * result;
        } else {
            return result * result;
        }
    }


    public static void main(String[] args) {
        _50_Pow _this = new _50_Pow();
        System.out.println(_this.myPow(2.0d, -2));
    }


}
