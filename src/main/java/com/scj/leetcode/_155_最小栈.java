package com.scj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    /**
     * 最简陋的做法
     */
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

    /**
     * 使用2个栈实现
     */
    public static class MinStack2 {

        private LinkedList<Integer> stack;

        private LinkedList<Integer> minStack;


        /** initialize your data structure here. */
        public MinStack2() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.addFirst(x);
            Integer first = minStack.peekFirst();
            //重点这个=
            if(first==null || first >= x){
                minStack.addFirst(x);
            }
        }

        public void pop() {
            Integer first = stack.pollFirst();
            if(Objects.equals(first,minStack.peekFirst())){
                minStack.pollFirst();
            }
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst();
        }
    }

    /**
     * 保留最小值
     * 如果出现更小的 包括等于
     * 那么先把之前的最小值压入
     */
    public static class MinStack3 {


        private LinkedList<Integer> stack;

        Integer minNumber;

        /** initialize your data structure here. */
        public MinStack3() {
            stack = new LinkedList<>();
        }

        public void push(int x) {

            if(minNumber ==null){
                minNumber = x;
            }else if(minNumber >=x){
                stack.push(minNumber);
                minNumber =x;
            }
            stack.push(x);
        }

        public void pop() {
            Integer number = stack.pollFirst();
            if(Objects.equals(minNumber,number)){
                minNumber = stack.pollFirst();
            }
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return minNumber;
        }
    }

    public static class MinStack4 {

        private LinkedList<Long> stack = new LinkedList<>();

        private Long min;

        /** initialize your data structure here. */
        public MinStack4() {

        }

        public void push(int x) {
            if(min ==null){
                min = (long)x;
            }
            stack.push((long)x-min);
            if(min > x){
                min =(long)x;
            }
        }

        public void pop() {
            Long first = stack.pollFirst();
            if(first<0){
                min -= first;
            }
            if(stack.isEmpty()){
                min = null;
            }
        }

        public int top() {
            Long first = stack.peekFirst();
            if(first<0){
                return min.intValue();
            }else{
                return (int)(min+first);
            }
        }

        public int getMin() {
            return min.intValue();
        }
    }

    public static void main(String[] args) {
        MinStack4 minStack = new MinStack4();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        System.out.println(minStack.top());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.getMin());
    }

}
