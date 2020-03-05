package com.scj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  �ⷨ https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
 *  1. ��2��ջ ��һ��ջ����ʵ�����ݣ�һ��ջ������С���ݣ���Ϊ��ջ�����Ժ������ӵĴ�������Ӱ��֮ǰ��С��
 *  2. ��һ�����ֱ����С�������ֻ�С������ʱ����ջ���֮ǰ�Ǹ�����ѹ��
 *  3. ջ���汣���ֵ
 *
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _155_��Сջ {

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
