package com.scj.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 每次都选择最重的2块石头
 * https://leetcode-cn.com/problems/last-stone-weight/
 * @author shengchaojie
 * @date 2020-03-09
 **/
public class _1046_最后一块石头的重量 {

    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)return stones[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());

        for(int i = 0 ; i<stones.length;i++){
            queue.add(stones[i]);
        }

        while(queue.size()>=2){
            queue.add(Math.abs(queue.poll()-queue.poll()));
        }

        return queue.poll();

    }

    public static void main(String[] args) {
        _1046_最后一块石头的重量 _this = new _1046_最后一块石头的重量();
        int[] test = {2,7,4,1,8,1};
        System.out.println(_this.lastStoneWeight(test));
    }

}
