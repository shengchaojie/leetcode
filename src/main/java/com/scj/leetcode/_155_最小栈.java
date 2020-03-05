package com.scj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  解法 https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
 *  1. 用2个栈 ，一个栈保存实际数据，一个栈保存最小数据，因为是栈，所以后面增加的大数不会影响之前的小数
 *  2. 用一个数字标记最小，当出现还小的数字时，往栈里把之前那个数字压入
 *  3. 栈里面保存差值
 *
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _155_最小栈 {

    static class MinStack {

        List<Integer> arrayList = new ArrayList<>();

        Integer min = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            arrayList.add(0,x);

            min = min == null ? x : Math.min(min, x);
        }

        public void pop() {
            int x = arrayList.get(0);
            arrayList.remove(0);
            min = arrayList.stream().reduce(Integer::min).orElse(null);
        }

        public int top() {
            return arrayList.get(0);
        }

        public int getMin() {
            if(min ==null){
                throw new IllegalArgumentException("no nums");
            }
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-3);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
