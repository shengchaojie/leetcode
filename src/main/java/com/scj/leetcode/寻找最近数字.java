package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-03-29
 **/
public class 寻找最近数字 {


    public int seek_before(int[] arr, int target) {
        if (arr == null || arr.length == 0) throw new RuntimeException("not existed");
        int left = 0;
        int right = arr.length - 1;
        while (right-left>1) {
            int mid = (left + right) >> 1;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[left]==target?arr[left-1]:arr[left];
    }

    public static void main(String[] args) {
        寻找最近数字 _this = new 寻找最近数字();
//        System.out.println(_this.seek_before(new int[]{1, 2, 3, 4, 5, 6, 7}, 6));
//        System.out.println(_this.seek_before(new int[]{1,5,7}, 4));
        System.out.println(_this.seek_before(new int[]{1,5,7,10,12}, 6));
        System.out.println(_this.seek_before(new int[]{1,5,7,10,12}, 7));
        System.out.println(_this.seek_before(new int[]{1,5,7,10,12}, 10));
        System.out.println(_this.seek_before(new int[]{1,5,7,10,12}, 12));
    }

}

