package com.scj.leetcode;

/**
 * 后插法 最优解
 * 新建一个数组居然也可以。。分别取出最小的放进新数组
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 *
 * @author shengchaojie
 * @date 2020-03-03
 **/
public class 合并排序的数组 {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if(A[i]>B[j]){
                A[k--]=A[i--];
            }else{
                A[k--]=B[j--];
            }
        }
        //B内可能存在比A最小的还小的情况
        while(j>=0){
            A[j]=B[j--];

        }

    }

    public static void main(String[] args) {
        合并排序的数组 _this = new 合并排序的数组();
        int[] a = new int[]{4,5,6, 0, 0, 0};
        int[] b = new int[]{1, 2, 3};
        _this.merge(a, 3, b, 3);

    }

}
