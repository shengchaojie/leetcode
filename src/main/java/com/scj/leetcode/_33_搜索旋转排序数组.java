package com.scj.leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * ÄæÏòË¼Î¬ ¡£¡£
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _33_ËÑË÷Ğı×ªÅÅĞòÊı×é {

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)return -1;
        int mid =0;
        int start = 0, end = nums.length - 1;
        if(nums[start]==target)return start;
        if(nums[end]==target)return end;
        while (start <= end) {
             mid = (start+end)/2;
             if(nums[mid]==target)return mid;
             if(nums[mid] > nums[end]){//ËµÃ÷×ó°ë±ßÓĞĞò
                if(target < nums[mid] && target >= nums[start]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
             }else{//ÓÒ°ë±ßÓĞĞò
                if(target> nums[mid] && target <= nums[end]){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
             }
        }
        if(nums[start]==target){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        _33_ËÑË÷Ğı×ªÅÅĞòÊı×é _this = new _33_ËÑË÷Ğı×ªÅÅĞòÊı×é();
        System.out.println(_this.search(new int[]{1,3}, 2));
    }

}
