package com.scj.leetcode;

/**
 * ��巨 ���Ž�
 * �½�һ�������ȻҲ���ԡ����ֱ�ȡ����С�ķŽ�������
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 *
 * @author shengchaojie
 * @date 2020-03-03
 **/
public class �ϲ���������� {

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
        //B�ڿ��ܴ��ڱ�A��С�Ļ�С�����
        while(j>=0){
            A[j]=B[j--];

        }

    }

    public static void main(String[] args) {
        �ϲ���������� _this = new �ϲ����������();
        int[] a = new int[]{4,5,6, 0, 0, 0};
        int[] b = new int[]{1, 2, 3};
        _this.merge(a, 3, b, 3);

    }

}
