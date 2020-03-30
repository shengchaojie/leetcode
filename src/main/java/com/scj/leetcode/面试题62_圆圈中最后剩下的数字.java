package com.scj.leetcode;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 下一个删除的数 等于当前删除数的下一个坐标 乘以位移
 * @author shengchaojie
 * @date 2020-03-30
 **/
public class 面试题62_圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {
        if(n==1)return 0;
        return (m%n + lastRemaining(n-1,m))%n;
    }

}
