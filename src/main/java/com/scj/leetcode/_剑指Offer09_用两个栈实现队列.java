package com.scj.leetcode;

import java.util.Stack;

/**
 * @author shengchaojie
 * @date 2020/6/30
 **/
public class _剑指Offer09_用两个栈实现队列 {

    class CQueue {


        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            in.add(value);
        }

        public int deleteHead() {
            if(out.isEmpty()){
                if(in.isEmpty()){
                    return -1;
                }else{
                    while (!in.isEmpty()){
                        out.push(in.pop());
                    }
                    return out.pop();
                }
            }else{
                return out.pop();
            }
        }
    }

}
