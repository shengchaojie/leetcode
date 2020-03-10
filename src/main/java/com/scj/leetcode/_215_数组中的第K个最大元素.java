package com.scj.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author shengchaojie
 * @date 2020-03-10
 **/
public class _215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        for(int j=k;j<nums.length;j++){
            if(nums[j]>queue.peek()){
                queue.poll();
                queue.add(nums[j]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        _215_数组中的第K个最大元素 _this = new _215_数组中的第K个最大元素();
        System.out.println(_this.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

}
