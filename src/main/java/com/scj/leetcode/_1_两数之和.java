package com.scj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap ����
 * https://leetcode-cn.com/problems/two-sum/submissions/
 * @author shengchaojie
 * @date 2019-06-18
 **/
public class _1_����֮�� {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> index = new HashMap<>();
        for(int i =0 ; i< nums.length ;i++){
            index.put(nums[i],i);
        }
        for(int i =0 ; i< nums.length ;i++){
            Integer bucket = index.get(target-nums[i]);
            if(bucket !=null && bucket != i){
                return new int[]{i,bucket};
            }
        }

        return new int[]{};

    }
    public static void main(String[] args) {
        _1_����֮�� runner = new _1_����֮��();
        int[] result = runner.twoSum(new int[]{3,3},6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
